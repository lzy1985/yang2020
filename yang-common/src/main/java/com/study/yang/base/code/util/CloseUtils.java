package com.study.yang.base.code.util;

import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/7 上午9:25
 * @Description
 */
@Slf4j
public class CloseUtils {
    private CloseUtils() {
    }

    public static void closeResource(Closeable closeable) {
        try {

            if (closeable != null) {
                closeable.close();
                closeable = null;
            }
        } catch (IOException e) {
            log.error("IOException thrown while closing Closeable.", e);
        }
    }

    public static void closeResources(Closeable... clos)  {
        for (Closeable closeable : clos) {
            closeResource(closeable);
        }
    }
}
