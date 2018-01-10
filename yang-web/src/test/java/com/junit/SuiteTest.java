package com.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2018/1/11 上午5:47
 * @Description
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {ATest.class,BTest.class})
public class SuiteTest {
}
