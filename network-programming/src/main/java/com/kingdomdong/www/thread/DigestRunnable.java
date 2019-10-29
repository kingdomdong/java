package com.kingdomdong.www.thread;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

/**
 * @author 0049002907
 * @since 2019.01.28
 */
public class DigestRunnable implements Runnable {

    private String filename;

    public DigestRunnable(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            try (InputStream fileInputStream = new BufferedInputStream(new FileInputStream(filename));
                    DigestInputStream digestInputStream = new DigestInputStream(fileInputStream,
                            messageDigest)) {
                int c;
                while ((c = digestInputStream.read()) != -1) {
                    System.out.print((char) c);
                }
                byte[] digest = messageDigest.digest();
                
                StringBuilder result = new StringBuilder(filename);
                result.append(": ");
                result.append(DatatypeConverter.printHexBinary(digest));
                System.out.println(result);
            }
        } catch (IOException e) {
            System.err.println(e);
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e);
        }
    }
    
    public static void main(String[] args) {
        for (String filename : args) {
            DigestRunnable digestRunnable = new DigestRunnable(filename);
            Thread thread = new Thread(digestRunnable);
            thread.start();
        }
    }

}
