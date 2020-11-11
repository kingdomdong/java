package com.king.interview.chp4.thread;

/**
 * run() & start() methods in Thread test
 *
 * @author Yum
 * @version 1.0
 * @since 2020-09-16 22:17:35
 */
public class RunStartImplementsRunnable implements Runnable {

    public static void test1() {
        System.out.println("test1(): begin");
        Thread thread1 = new Thread(new RunStartImplementsRunnable());
        thread1.start();
        System.out.println("test1(): end");
    }

    public static void test2() {
        System.out.println("test2(): begin");
        Thread thread2 = new Thread(new RunStartImplementsRunnable());
        thread2.run();
        System.out.println("test2(): end");
    }

    @Override
    public void run() {
        System.out.println("RunStartThread: begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("RunStartThread: end");
    }

}
