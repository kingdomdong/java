package com.king;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            long num = Long.parseLong(reader.readLine());
            System.out.println(num * num * num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}