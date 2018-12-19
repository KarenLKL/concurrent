package com.newbee.concurrent.singleton;

import java.util.Objects;

/**
 * 懒汉模式——双重检测+volatile——线程安全
 */
public class Example4 {
    private static volatile Example4 instance;

    private Example4() {

    }

    public static Example4 getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (Example4.class) {
                if (Objects.isNull(instance)) {
                    instance = new Example4();
                }
            }
        }
        return instance;
    }

}
