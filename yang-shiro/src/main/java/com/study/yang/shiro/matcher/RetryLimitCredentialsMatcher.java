package com.study.yang.shiro.matcher;

import com.study.yang.base.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/11 上午10:18
 * @Description
 */
@Slf4j
public class RetryLimitCredentialsMatcher extends HashedCredentialsMatcher {

    private final static String RETRY_LIMIT_CACHE_NAME = "retryLimitCache";
    private final static int ERROR_PASSWORD_COUNNT=5;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        String username = (String) authcToken.getPrincipal();
        String key =passWordKey(username);

        long a =redisUtil.incr(key,1);
        if ( a> ERROR_PASSWORD_COUNNT) {
            log.warn("username: " + username + " tried to login more than 5 times in period");
            throw new ExcessiveAttemptsException("用户名: " + username + " 密码连续输入错误超过5次，锁定半小时！");
        }

        boolean matches = super.doCredentialsMatch(authcToken, info);
        if (matches) {
            redisUtil.del(key);
        }
        return matches;
    }

    /**
     * 存储密码都私有key
     * @param key
     * @return
     */
    private String passWordKey(String key){
        StringBuilder sb = new StringBuilder(RETRY_LIMIT_CACHE_NAME);
        sb.append("_");
        sb.append(key);
        return sb.toString();
    }
}
