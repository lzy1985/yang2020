package com.yang.study.guava;

import com.google.common.base.Optional;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2018/1/6 上午6:00
 * @Description
 */
public class GuavaTester {

    public static void main(String args[]){
        GuavaTester guavaTester = new GuavaTester();

//        Integer value1 =  new Integer(5);
//        Integer value2 =  new Integer(10);
//        //Optional.fromNullable - allows passed parameter to be null.
//        Optional<Integer> a = Optional.fromNullable(value1);
//        //Optional.of - throws NullPointerException if passed parameter is null
//        Optional<Integer> b = Optional.of(value2);
//
//        System.out.println(Optional.absent());
//        System.out.println(guavaTester.sum(a,b));
        Optional<Integer> possible=Optional.of(6);
        Optional<Integer> absentOpt=Optional.absent();
        Optional<Integer> NullableOpt=Optional.fromNullable(null);
        Optional<Integer> NoNullableOpt=Optional.fromNullable(10);
        if(possible.isPresent()){
            System.out.println("possible isPresent:"+possible.isPresent());
            System.out.println("possible value:"+possible.get());
        }
        if(absentOpt.isPresent()){
            System.out.println("absentOpt isPresent:"+absentOpt.isPresent()); ;
        }
        if(NullableOpt.isPresent()){
            System.out.println("fromNullableOpt isPresent:"+NullableOpt.isPresent()); ;
        }
        if(NoNullableOpt.isPresent()){
            System.out.println("NoNullableOpt isPresent:"+NoNullableOpt.isPresent()); ;
        }
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){
        //Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());

        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.or - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.or(new Integer(0));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        return value1 + value2;
    }
}
