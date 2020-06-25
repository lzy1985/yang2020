package com.yang.study.list;

import com.study.yang.base.util.JSONUtils;

import java.util.Iterator;
import java.util.List;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2018/1/22 下午3:05
 * @Description
 */
public class ArrayList {

    private static List<String> list;

    static {
        list = new java.util.ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        list.add("ff");
        list.add("gg");
    }

    public static void main(String[] args) {
        System.out.println("_++++++++");
        removeFori();
        removeForEach();
        removeItertor1();
        removeItertor2();

    }

    public static void removeFori(){
        System.out.println(JSONUtils.toJson(list));
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            list.remove(str);
        }
        //从后往前删除，可以删除干净
        for (int i = list.size()-1; i >=0; i--) {
            String str = list.get(i);
            list.remove(str);
            System.out.println(JSONUtils.toJson(list));
        }

        System.out.println(JSONUtils.toJson(list));
        System.out.println("---------");
    }

    public static void removeForEach(){
        System.out.println(JSONUtils.toJson(list));
        for (String str:list) {
            list.remove(str);
            System.out.println(JSONUtils.toJson(list));
        }
        System.out.println(JSONUtils.toJson(list));
    }

    public static void removeItertor1(){
        System.out.println(JSONUtils.toJson(list));
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();
            it.remove();
        }
        System.out.println(JSONUtils.toJson(list));
    }

    public static void removeItertor2(){
        System.out.println(JSONUtils.toJson(list));
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();
            list.remove(str);
            System.out.println(JSONUtils.toJson(list));
        }
        System.out.println(JSONUtils.toJson(list));
    }
}
