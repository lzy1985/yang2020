package com.junit;

import org.junit.*;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2018/1/11 上午5:29
 * @Description
 */
public class ATest {

    @BeforeClass
    public static void a_BeforeClass(){
        System.out.println("BeforeClass:");
    }

    @Before
    public void a_before(){
        System.out.println("before:");
    }

    @Test
    public void a_test(){
        String obj1 = "junit";
        String obj2 = "junit";
        String obj3 = "test";
        String obj4 = "test";
        String obj5 = null;
        int var1 = 1;
        int var2 = 2;
        int[] arithmetic1 = { 1, 2, 3 };
        int[] arithmetic2 = { 1, 2, 3 };

        Assert.assertEquals(obj1, obj2);

        Assert.assertSame(obj3, obj4);

        Assert.assertNotSame(obj2, obj4);

        Assert.assertNotNull(obj1);

        Assert.assertNull(obj5);

        Assert.assertTrue(var1!=var2);

        Assert.assertArrayEquals(arithmetic1, arithmetic2);
        System.out.println("a_Test:");
    }

    @After
    public void a_after(){
        System.out.println("after:");
    }

    @AfterClass
    public static void a_AfterClass(){
        System.out.println("AfterClass:");
    }

    @Ignore
    public void a_Ignore(){
        System.out.println("Ignore:");
    }
}
