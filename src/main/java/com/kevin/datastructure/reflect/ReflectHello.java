package com.kevin.datastructure.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @author kevin
 * @version 1.0
 * @date 2021-03-08 9:37
 */
@Slf4j
public class ReflectHello {

    public ReflectHello() {
    }

    public void sayHello(String name){
        log.info(name+":对你说Hello");
    }

    public static void main(String[] args) {
        try {
            ReflectHello clazz = (ReflectHello) Class.forName("com.kevin.datastructure.reflect.ReflectHello").newInstance();
            Method method = clazz.getClass().getMethod("sayHello", String.class);
            method.invoke(clazz,"张三");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
