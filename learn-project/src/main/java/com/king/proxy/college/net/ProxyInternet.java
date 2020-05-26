package com.king.proxy.college.net;

import java.util.Arrays;
import java.util.List;

public class ProxyInternet implements Internet {

    private Internet internet = new RealInternet();

    private static List<String> bannedSites = Arrays
            .asList("abc.com",
                    "def.com",
                    "ijk.com",
                    "lmn.com");

    @Override
    public void connectTo(String serverHost) throws Exception {
        if (bannedSites.contains(serverHost.toLowerCase())) {
            throw new Exception(serverHost + " Access Denied");
        }

        internet.connectTo(serverHost);
    }

}
