package com.study.yang.shiro.session;

import org.apache.shiro.session.Session;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/10/12 下午4:41
 * @Description 为了防止存库的扩展、所以创建此接口
 */
public interface ShiroSessionRepository {

    /**
     * 保存session
     * @param session
     */
    void saveSession(Session session);

    /**
     * 更改session
     * @param session
     */
    void updateSession(Session session);

    /**
     * 删除session
     * @param sessionId
     */
    void deleteSession(Serializable sessionId);


    /**
     * 根据sessionId获取session
     * @param sessionId
     * @return
     */
    Session getSession(Serializable sessionId);

    /**
     * 获取所有session
     * @return
     */
    Collection<Session> getSessions();
}
