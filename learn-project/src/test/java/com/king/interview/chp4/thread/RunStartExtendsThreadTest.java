package com.king.interview.chp4.thread;

import org.junit.jupiter.api.Test;

/**
 * run() and start() methods in Thread
 *
 * @author Yum
 * @version 1.0
 * @since 2020-09-16 22:33:26
 */
public class RunStartExtendsThreadTest {

    /**
     * test1(): begin
     * test1(): end
     * RunStartExtendsThread: begin
     * RunStartExtendsThread: end
     * <p>
     * test2(): begin
     * RunStartExtendsThread: begin
     * RunStartExtendsThread: end
     * test2(): end
     * <p>
     * OR
     * <p>
     * test1(): begin
     * RunStartExtendsThread: begin
     * test1(): end
     * RunStartExtendsThread: end
     * <p>
     * test2(): begin
     * RunStartExtendsThread: begin
     * RunStartExtendsThread: end
     * test2(): end
     */
    @Test
    void should_run_is_synchronous_in_thread() {
        RunStartExtendsThread.test1();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        RunStartExtendsThread.test2();
    }

}
