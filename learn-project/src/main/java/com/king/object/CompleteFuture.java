package com.king.object;

import java.util.concurrent.CompletableFuture;

public class CompleteFuture {

    public static void main(String[] args) {
        printFirst();
        System.out.println("World");
    }

    private static void printFirst() {
        CompletableFuture.runAsync(() ->{
            System.out.println("Hello");
        });
    }

}
