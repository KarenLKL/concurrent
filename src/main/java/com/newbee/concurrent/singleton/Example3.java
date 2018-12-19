package com.newbee.concurrent.singleton;

import java.util.Objects;

/**
 * 懒汉模式——双重检测——线程不安全
 */
public class Example3 {
    private static Example3 instance;

    private Example3() {

    }

    public static Example3 getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (Example3.class) {
                if (Objects.isNull(instance)) {
                    instance = new Example3();
                }
            }
        }
        return instance;
    }

}
