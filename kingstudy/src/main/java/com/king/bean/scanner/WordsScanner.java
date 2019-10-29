package com.king.bean.scanner;

import java.util.Scanner;

public class WordsScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(" ");
        Character firstLetter = null;
        while (scanner.hasNext("\r\n")) {
            String string = (String) scanner.next().toLowerCase();
            System.out.println(string);
            if (firstLetter == null) {
                firstLetter = string.charAt(0);
            } else {
                if (!firstLetter.equals(string.charAt(0))) {
                    System.out.println("Not correct.");
                    scanner.close();
                    System.exit(0);
                }
            }
        }

        System.out.println("Good! That's correct!");
        scanner.close();
    }

}
