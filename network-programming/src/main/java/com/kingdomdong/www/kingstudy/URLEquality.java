package com.kingdomdong.www.kingstudy;

import java.net.MalformedURLException;
import java.net.URL;

public class URLEquality {
    
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.ibiblio.org/");
            URL ibibilio = new URL("http://ibiblio.org/");
            if (url.equals(ibibilio)) {
                System.out.println(url + " is the same as " + ibibilio);
            } else {
                System.out.println(url + " is not the same as " + ibibilio);
            }
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
    }

}
