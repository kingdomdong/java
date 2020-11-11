package com.king.interview.chp4.thread;

import org.junit.jupiter.api.Test;

/**
 * run() and start() methods in Thread
 *
 * @author Yum
 * @version 1.0
 * @since 2020-09-16 22:13:58
 */
public class RunStartImplementsRunnableTest {

    /**
     * 👹 WHY
     * <p>🍏with new Thread(RunStartThreadImplementsRunnable::new):
     * <p>test1(): begin
     * <p>test1(): end
     * <p></p>
     * <p>test2(): begin
     * <p>test2(): end
     * <p></p>
     * <p></p>
     * <p>🍇AND with new Thread(new RunStartThreadImplementsRunnable()):
     * <p></p>
     * <p>test1(): begin
     * <p>RunStartThread: begin
     * <p>test1(): end
     * <p>RunStartThread: end
     * <p></p>
     * <p>test2(): begin
     * <p>RunStartThread: begin
     * <p>RunStartThread: end
     * <p>test2(): end
     * <p></p>
     * <p></p>
     * <p>🥝AND with new Thread(() -> {...}):
     * <p></p>
     * <p>test1(): begin
     * <p>RunStartThread: begin
     * <p>test1(): end
     * <p>RunStartThread: end
     * <p></p>
     * <p>test2(): begin
     * <p>RunStartThread: begin
     * <p>RunStartThread: end
     * <p>test2(): end
     */
    @Test
    void should_run_is_synchronous_with_five_minutes_in_thread() {
        RunStartImplementsRunnable.test1();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        RunStartImplementsRunnable.test2();
    }

}
