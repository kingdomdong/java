package com.king.concurrent;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * asynchronous future
 *
 * @author Yum
 * @version 1.0
 * @since 2020-08-24 10:15:163
 */
public class CompleteFutureTest {

    public static void main(String[] args) {
        long start = System.nanoTime();
        Executor executor = Executors.newFixedThreadPool(20, r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });
        Stream<CompletableFuture<Void>> futureStream = LongStream.range(0, 1_000_000).mapToObj(number -> CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executor));

        // 100 threads   - 117_694 msecs;
        // 20 threads    - 561_433 msecs;
        // 4 threads     - 2_932_437 msecs;
        CompletableFuture.allOf(futureStream.toArray(CompletableFuture[]::new)).join();
        System.out.println("duration - msecs: " + (System.nanoTime() - start) / 1_000_000);
    }

}
