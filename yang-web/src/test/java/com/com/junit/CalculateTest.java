package com.com.junit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2018/1/11 上午5:58
 * @Description
 */
@RunWith(Parameterized.class)
public class CalculateTest {

    private Integer expected;
    private Integer first;
    private Integer second;

    public CalculateTest(Integer expected, Integer first, Integer second) {
        this.expected = expected;
        this.first = first;
        this.second = second;
    }


    @Parameterized.Parameters
    public static List addValue(){
        return Arrays.asList(new Integer[][] { { 3, 1, 2 }, { 5, 2, 3 },
                { 7, 3, 4 }, { 9, 4, 5 }, });
    }

    @Test
    public void sum() throws Exception {
        Calculate calculate = new Calculate();
        Assert.assertEquals(expected,calculate.sum(first,second));
    }

}