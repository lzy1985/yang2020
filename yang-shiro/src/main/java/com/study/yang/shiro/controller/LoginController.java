package com.study.yang.shiro.controller;

import com.study.yang.base.dto.ResponseDto;
import com.study.yang.shiro.dto.LoginDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/10/7 上午5:34
 * @Description
 */
@Controller
@RequestMapping
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "system/login";
    }

    /**
     * 登录
     *
     * @param loginDTO
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto login(@RequestBody LoginDTO loginDTO) {
        ResponseDto responseDto = ResponseDto.bulidSuccess();
        String passWord = loginDTO.getPassword();//Base64.decodeToString(loginDTO.getPassword());
        UsernamePasswordToken token = new UsernamePasswordToken(loginDTO.getUsername(), passWord);
        // 设置记住密码
        boolean isRememberMe = true;
        if (loginDTO.getRememberMe() != null) {
            isRememberMe = (1 == loginDTO.getRememberMe());
        }
        token.setRememberMe(isRememberMe);
        Subject subject = SecurityUtils.getSubject();
        String msg = null;
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            msg = "用户名或密码错误！";
        } catch (DisabledAccountException e) {
            msg = "账号被锁定，请稍后登录！";
        } catch (IncorrectCredentialsException e) {
            msg = "用户名或密码错误！";
        } catch (ExcessiveAttemptsException e) {
            msg = "密码连续输入错误超过5次，锁定半小时";
        } catch (Throwable e) {
            msg = "未知异常，请联系管理员";
        } finally {
            if (null != msg) {
                responseDto.setCode(ResponseDto.FAIL);
                responseDto.setMessage(msg);
            }
        }
        return responseDto;
    }
}
