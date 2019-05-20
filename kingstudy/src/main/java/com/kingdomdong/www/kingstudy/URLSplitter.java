package com.kingdomdong.www.kingstudy;

import java.net.MalformedURLException;
import java.net.URL;

public class URLSplitter {
    
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                URL url = new URL(args[i]);
                System.out.println("The URL is " + url);
                System.out.println("The scheme is " + url.getProtocol());
                System.out.println("The user info is " + url.getUserInfo());
                
                String host = url.getHost();
                if (host != null) {
                    
                } else {
                    System.out.println("The host is null.");
                }
                
                System.out.println("The authority is " + url.getAuthority());
                System.out.println("The userInfo is " + url.getUserInfo());
                System.out.println("The port is " + url.getPort());
                System.out.println("The path is " + url.getPath());
                System.out.println("The ref is " + url.getRef());
                System.out.println("The query string is " + url.getQuery());
            } catch (MalformedURLException ex) {
                System.err.println(args[i] + "is not a URL I understand.");
            }
            System.out.println();
        }
    }

}
