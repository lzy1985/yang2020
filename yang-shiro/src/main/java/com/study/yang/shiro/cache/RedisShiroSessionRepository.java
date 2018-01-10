package com.study.yang.shiro.cache;

import com.study.yang.base.util.RequestContextHolder;
import com.study.yang.shiro.session.ShiroSessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/10/12 下午4:46
 * @Description
 */
@Slf4j
public class RedisShiroSessionRepository implements ShiroSessionRepository {

    /**
     * session前缀
     */
    private final String REDIS_SHIRO_SESSION = "shiro-activeSession:";

    private RedisTemplate redisTemplate;

    private long time =1800;

    @Override
    public void saveSession(Session session) {
        if (null == session || null == session.getId()) {
            log.error("session or sessionId is null on to execute the saveSession method");
            throw new NullPointerException("session or sessionId is null on to execute the saveSession method");
        }
        //存储在线状态
//        if(null == session.getAttribute()){
//            session.setAttribute(,);
//        }

        //缓存session
        String key = getKey(session.getId());
        redisTemplate.opsForValue().set(key,session,time, TimeUnit.SECONDS);

        //存入request中一份
        String requestKey = getRequestKey(session.getId());
        HttpServletRequest request = RequestContextHolder.getRequest();
        request.setAttribute(requestKey, session);
    }
    @Override
    public void updateSession(Session session) {
        if (null == session || null == session.getId()) {
            log.error("session or sessionId is null on to execute the saveSession method");
            throw new NullPointerException("session or sessionId is null on to execute the saveSession method");
        }
        //存储在线状态
//        if(null == session.getAttribute()){
//            session.setAttribute(,);
//        }

        //缓存session
        String key = getKey(session.getId());
        Session readSession = getSession(session.getId(),true);
        //判断从缓存中读取的数据和本次要更改的数据的最后更新时间是否一致，一致则不更新
        if(!readSession.getLastAccessTime().equals(session.getLastAccessTime())) {
            redisTemplate.opsForValue().set(key, session, time, TimeUnit.SECONDS);
            //存入request中一份
            String requestKey = getRequestKey(session.getId());
            HttpServletRequest request = RequestContextHolder.getRequest();
            request.setAttribute(requestKey, session);
        }
    }

    @Override
    public void deleteSession(Serializable sessionId) throws NullPointerException{
        log.debug("deleteSessions："+System.currentTimeMillis());
        if (null == sessionId) {
            log.error("sessionId is null on to execute the deleteSession method");
            throw new NullPointerException("sessionId is null on to execute the deleteSession method");
        }
        redisTemplate.delete(getKey(sessionId));
    }

    @Override
    public Session getSession(Serializable sessionId) throws NullPointerException {
        return getSession(sessionId,false);
    }

    /**
     * 获取session数据
     * @param sessionId
     * @param readFromCache 是否强制从缓存中获取，默认false
     * @return
     * @throws NullPointerException
     */
    private Session getSession(Serializable sessionId,boolean readFromCache) throws NullPointerException {
        if (null == sessionId) {
            log.error("sessionId is null on to execute the getSession method");
            throw new NullPointerException("sessionId is null on to execute the getSession method");
        }
        Session session = null;
        String key = getKey(sessionId);
        String requestKey = getRequestKey(sessionId);
        HttpServletRequest request = RequestContextHolder.getRequest();
        if(!readFromCache) {
            if (null != request && null != request.getAttribute(requestKey)) {
                session = (Session) request.getAttribute(requestKey);
            }
        }
        if (null == session) {
            session = (Session) redisTemplate.opsForValue().get(key);
            request.setAttribute(requestKey, session);
        }
        return session;
    }

    @Override
    public Collection<Session> getSessions() {
        Collection<Session> sessions = null;
        log.debug("getSessions："+System.currentTimeMillis());
        Set<String> keys = redisTemplate.keys(this.REDIS_SHIRO_SESSION+"*");
        sessions = new ArrayList<Session>();
        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            Session session = (Session) redisTemplate.opsForValue().get(key);
            if(null != session){
                sessions.add(session);
            }
        }
        return sessions;
    }

    /**
     * 生成缓存key
     *
     * @param sessionId
     * @return
     */
    private String getKey(Serializable sessionId) {
        return new StringBuilder(this.REDIS_SHIRO_SESSION).append(sessionId).toString();
    }

    /**
     * 存入request的key
     *
     * @param sessionId
     * @return
     */
    private String getRequestKey(Serializable sessionId) {
        return new StringBuilder(Thread.currentThread().getName()).append(getKey(sessionId)).toString();
    }



    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
