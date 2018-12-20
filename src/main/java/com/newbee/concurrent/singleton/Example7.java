package com.newbee.concurrent.singleton;

import java.security.PrivateKey;

/**
 * 枚举——线程安全（推荐）
 */
public class Example7 {

    private Example7() {

    }

    public static Example7 getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }

    private enum  Singleton{
        INSTANCE;
        private Example7 singleton;
        Singleton(){
            singleton=new Example7();
        }
        public Example7 getSingleton(){
            return singleton;
        }
    }
}
