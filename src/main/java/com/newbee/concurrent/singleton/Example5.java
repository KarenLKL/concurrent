package com.newbee.concurrent.singleton;

import java.util.Objects;

/**
 * 饿汉模式——线程安全
 */
public class Example5 {
    private static volatile Example5 instance=new Example5();

    private Example5() {

    }

    public static Example5 getInstance() {
        return instance;
    }

}
