package com.king.interview.chp4.thread;

/**
 * run() & start() methods in Thread
 *
 * @author Yum
 * @version 1.0
 * @since 2020-09-16 22:34:53
 */
public class RunStartExtendsThread extends Thread {

    public static void test1() {
        System.out.println("test1(): begin");
        RunStartExtendsThread runStartExtendsThread1 = new RunStartExtendsThread();
        runStartExtendsThread1.start();
        System.out.println("test1(): end");
    }

    public static void test2() {
        System.out.println("test2(): begin");
        RunStartExtendsThread runStartExtendsThread2 = new RunStartExtendsThread();
        runStartExtendsThread2.run();
        System.out.println("test2(): end");
    }


    @Override
    public void run() {
        System.out.println("RunStartExtendsThread: begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("RunStartExtendsThread: end");
    }



}
