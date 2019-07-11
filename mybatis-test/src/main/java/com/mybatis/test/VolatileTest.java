package com.mybatis.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Despriction: TODO
 * @Author: zhousheng
 * @CreatedTime: 2019-07-08 15:27
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class VolatileTest {

    public volatile int inc = 0;

//    public  void increase() {
//        inc++;
//    }
    //保证原子性：
    //方法一：添加synchronized关键字
/*    public synchronized void increase() {
        inc++;
    }*/
    //方法二：加锁
/*    Lock lock = new ReentrantLock();
    public  void increase() {
        lock.lock();
        inc++;
        lock.unlock();
    }*/
    //方法三：使用原子类
    //原子Integer类型，使用原子类型
    private AtomicInteger atomicInteger = new AtomicInteger();
    //底层使用CAS保证原子性
    public  void increase() {
        atomicInteger.getAndIncrement();
    }


    public static void main(String[] args) {
        final VolatileTest volatileTest = new VolatileTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        volatileTest.increase();
                };
            }.start();
        }
        //保证前面的线程都执行完
        while(Thread.activeCount()>1)
            Thread.yield();
        System.out.println(volatileTest.inc);
        System.out.println(volatileTest.atomicInteger.get());
    }
}
