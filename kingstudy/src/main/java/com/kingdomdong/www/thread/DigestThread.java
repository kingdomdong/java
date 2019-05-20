package com.kingdomdong.www.thread;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class DigestThread extends Thread {
    
    private String filename;
    
    public DigestThread(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void run() {
        try {
          FileInputStream inputStream = new FileInputStream(filename);
          MessageDigest sha = MessageDigest.getInstance("SHA-256");
          DigestInputStream digestInputStream = new DigestInputStream(inputStream, sha);
          int c;
          while ((c = digestInputStream.read()) != -1) 
              System.out.print((char)c);
          digestInputStream.close();
          byte[] digest = sha.digest();
          
          StringBuilder result = new StringBuilder(filename);
          result.append(": ");
          result.append(DatatypeConverter.printHexBinary(digest));
          System.out.println(result);
        } catch (IOException e) {
            System.err.println(e);
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e);
        }
    }
    
    public static void main(String[] args) {
        for (String filename : args) {
            Thread thread = new DigestThread(filename);
            thread.start();
        }
    }

}
