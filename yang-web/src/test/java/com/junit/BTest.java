package com.junit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2018/1/11 上午5:46
 * @Description
 */
public class BTest {

    @Rule
    public TestName name = new TestName();

    @Test
    public void b_test(){
        System.out.println("b_test:");
    }

    @Test
    public void testA(){
        System.out.println("testA");
        Assert.assertEquals("testA",name.getMethodName());
    }
    @Test
    public void testB(){
        System.out.println("testB");
        Assert.assertEquals("testB",name.getMethodName());
    }
}
