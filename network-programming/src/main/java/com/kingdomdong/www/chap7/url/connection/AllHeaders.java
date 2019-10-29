package com.kingdomdong.www.chap7.url.connection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Example 7-5 Print the entire HTTP header
 * 
 * command parameter:
 *  https://www.oreilly.com
 * result:
 *  null: HTTP/1.1 200 OK
 *  Server: Apache/2.4.7 (Ubuntu)
 *  Last-Modified: Tue, 12 Feb 2019 09:30:02 GMT
 *  Content-Type: text/html
 *  Cache-Control: max-age=4794
 *  Expires: Wed, 13 Feb 2019 10:20:02 GMT
 *  Date: Wed, 13 Feb 2019 09:00:08 GMT
 *  Content-Length: 29013
 *  Connection: keep-alive
 * 
 * @author 0049002907
 * @since 2019.02.13
 */
public class AllHeaders {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                URL url = new URL(args[i]);
                URLConnection uc = url.openConnection();
                for (int j = 0;; j++) {
                    String header = uc.getHeaderField(j);
                    if (header == null) {
                        break;
                    }
                    System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
                }
            } catch (MalformedURLException me) {
                System.err.println(args[i] + " is not a URL I understand.");
            } catch (IOException ie) {
                System.err.println(ie);
            }
            System.out.println();
        }
    }

}
