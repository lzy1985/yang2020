package com.study.yang.shiro.session;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/10/13 上午9:35
 * @Description
 */
@Slf4j
public class RedisSessionDao extends AbstractSessionDAO {

    private ShiroSessionRepository ShiroSessionRepository;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        if(log.isDebugEnabled()) {
            log.debug("创建seesion,id=[{}]", session.getId().toString());
        }
        ShiroSessionRepository.saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if(log.isDebugEnabled()) {
            log.debug("读取doReadSession：" + System.currentTimeMillis());
        }
        Session session = null;
        session = ShiroSessionRepository.getSession(sessionId);
        return session;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        //如果会话过期/停止 没必要再更新了
        try {
            if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
                return;
            }
        } catch (Exception e) {
            log.error("ValidatingSession error");
        }
        if(log.isDebugEnabled()) {
            log.debug("更改redisSessionDao：" + System.currentTimeMillis());
        }
        ShiroSessionRepository.updateSession(session);
    }

    @Override
    public void delete(Session session) {
        if(null == session || null == session.getId()){
            log.error("session is null on to execute the RedisSessionDao.delete method");
            throw new NullPointerException("session is null on to execute the RedisSessionDao.delete method");
        }
        if(log.isDebugEnabled()) {
            log.debug("删除redisSessionDao：" + System.currentTimeMillis());
        }
        ShiroSessionRepository.deleteSession(session.getId());
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return ShiroSessionRepository.getSessions();
    }

    public void setShiroSessionRepository(com.study.yang.shiro.session.ShiroSessionRepository shiroSessionRepository) {
        ShiroSessionRepository = shiroSessionRepository;
    }
}
