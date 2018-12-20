package com.newbee.concurrent.singleton;

import java.util.Objects;

/**
 * 懒汉模式——线程不安全
 */
public class Example1 {
    private static Example1 instance;

    private Example1() {

    }

    public static Example1 getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Example1();
        }
        return instance;
    }

}
