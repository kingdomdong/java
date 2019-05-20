package com.kingdomdong.www.proxy.selector;

import java.net.InetAddress;
import java.net.ProxySelector;
import java.net.UnknownHostException;

public class SelectorMain {

    public static void main(String[] args) {
        
        ProxySelector selector = new LocalProxySelector();
        ProxySelector.setDefault(selector);
        
        // obtain google IP:
        // 74.86.118.24 | 69.171.239.11 | 69.171.244.12 |
        // 31.13.64.49 | 173.252.100.32 | 172.217.24.4 | 69.171.229.73
        try {
            System.out.println(InetAddress.getByName("www.google.com").
                    getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        
    }
    
}
