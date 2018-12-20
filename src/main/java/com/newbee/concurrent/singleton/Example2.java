package com.newbee.concurrent.singleton;

import java.util.Objects;

/**
 * 懒汉模式——线程安全
 */
public class Example2 {
    private static Example2 instance;

    private Example2() {

    }

    public static synchronized Example2 getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Example2();
        }
        return instance;
    }

}
