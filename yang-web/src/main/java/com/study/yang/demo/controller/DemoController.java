package com.study.yang.demo.controller;

import com.study.yang.base.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/10/13 下午4:49
 * @Description
 */
@Controller
public class DemoController {

    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("/A")
    public void A(){
        redisUtil.set("demo:ceshi:aa","aa",180);
        redisUtil.set("demo:ceshi:bb","bb",180);
        redisUtil.set("demo:ceshi:cc","cc",180);
        System.out.println(redisUtil.get("demo:ceshi:aa"));
        System.out.println(redisUtil.get("demo:ceshi:bb"));
        System.out.println(redisUtil.get("demo:ceshi:bb"));
        redisUtil.keys("demo:ceshi:*");
    }
}
