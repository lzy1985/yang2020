package com.study.yang.shiro.realm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/11 上午10:10
 * @Description
 */
@Slf4j
@Component
public class ShiroDbRealm extends AuthorizingRealm {

//    @Lazy
//    @Autowired
//    private UserService userService;

    public ShiroDbRealm(CacheManager cacheManager, CredentialsMatcher matcher) {
        super(cacheManager, matcher);
    }

    /**
     * Shiro登录认证(原理：用户提交 用户名和密码  --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回 ---- shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authToken;

//        UserDTO userDTO = new UserDTO();
//        userDTO.setName(token.getUsername());
//        userDTO.setStatus(1);
//        List<UserDTO> list = userService.query(userDTO);
//        // 账号不存在
//        if (list == null || list.isEmpty()) {
//            throw new UnknownAccountException();
//        }
//        UserDTO user = list.get(0);
//        // 账号停用
//        if (user.getLocked().intValue() == 0) {
//            throw new DisabledAccountException("帐号已经禁止登录！");
//        }
//        // 认证缓存信息
//        return new SimpleAuthenticationInfo(user, user.getPassword().toCharArray(), getName());
        return null;
    }

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("--------------------------------------------------------进入权限认证");
//        UserDTO currentUser = (UserDTO) principals.getPrimaryPrincipal();
//
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setRoles(currentUser.getRoleNameSet());
//        info.addStringPermissions(currentUser.getPermissionsSet());
//
//        return info;
        return null;
    }

    @Override
    public void onLogout(PrincipalCollection principals) {
//        System.out.println("--------------------------------------------------------进入退出");
        super.clearCachedAuthorizationInfo(principals);
//        CurrentUser currentUser = (CurrentUser) principals.getPrimaryPrincipal();
//        removeUserCache(currentUser);
    }

    /**
     * 清除用户缓存
     *
     * @param currentUser
     */
//    public void removeUserCache(CurrentUser currentUser) {
//        removeUserCache(currentUser.getLoginName());
//    }

    /**
     * 清除用户缓存
     *
     * @param loginName
     */
//    public void removeUserCache(String loginName) {
//        SimplePrincipalCollection principals = new SimplePrincipalCollection();
//        principals.add(loginName, super.getName());
//        super.clearCachedAuthenticationInfo(principals);
//    }
}
