package com.study.yang.base.monitor;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/12 下午12:20
 * @Description
 */
public class MonitorUtil {

    public static void recordOne(String name, long time) {
        String key = getKey(name);
        Monitor.recordOne(key, time);
    }

    private static String getKey(String name) {
        return name;
    }

    public static void recordOne(String name) {
        String key = getKey(name);
        Monitor.recordOne(key);
    }

    public static void decrRecord(String name) {
        String key = getKey(name);
        Monitor.decrRecord(key);
    }

    public static void recordMany(String name, long count, long time) {
        String key = getKey(name);
        Monitor.recordMany(key, count, time);
    }

    public static void recordSize(String name, long size) {
        String key = getKey(name);
        Monitor.recordSize(key, size);
    }

    public static void recordValue(String name, long count) {
        String key = getKey(name);
        Monitor.recordValue(key, count);
    }

    public static void recordName(String name) {
        Monitor.recordOne(name);
    }
}
