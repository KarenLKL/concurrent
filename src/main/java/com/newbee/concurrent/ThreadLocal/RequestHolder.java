package com.newbee.concurrent.ThreadLocal;

/**
 * 存放公用信息(比如用户信息)
 */
public class RequestHolder {
    /**
     * 内部实现为map结构
     */
    private final static ThreadLocal<Long> CONTAINER=new ThreadLocal<>();

    /**
     * set操作：已当前线程id为Key，userId为value
     * @param userId
     */
    public static void add(Long userId){
        CONTAINER.set(userId);
    }

    public static Long get(){
        return CONTAINER.get();
    }

    public static void remove(){
        CONTAINER.remove();
    }
}
