package com.kingdomdong.www.chap7.url.connection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Return the header
 * Example 7-4 reads URLs from the command line and uses these six methods to print their
 * content type, content length, content encoding, date of last modification, expiration
 * date, and current date.
 * 
 * command line parameter:
 *  http://www.oreilly.com/favicon.ico
 *  http://www.google.com
 *  http://www.baidu.com
 * result:
 *  {Content-type: text/html; charset=iso-8859-1
 *  Date: Wed Feb 13 16:48:26 CST 2019
 *  Expiration date: Tue Feb 26 17:27:22 CST 2019
 *  Content-length: 243
 *  
 *  Content-type: null
 *  
 *  Content-type: text/html
 *  Date: Wed Feb 13 15:45:30 CST 2019
 *  Last modified: Mon Jan 23 21:27:57 CST 2017
 *  Content-length: 2381}
 *  
 * @author 0049002907
 * @since 2019.02.13
 */
public class HeadViewer {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                URL url = new URL(args[i]);
                URLConnection urlConnection = url.openConnection();
                System.out.println("Content-type: " + urlConnection.getContentType());
                if (urlConnection.getContentEncoding() != null) {
                    System.out.println("Content-encoding: " + urlConnection.getContentEncoding());
                }
                if (urlConnection.getDate() != 0) {
                    System.out.println("Date: " + new Date(urlConnection.getDate()));
                }
                if (urlConnection.getLastModified() != 0) {
                    System.out.println("Last modified: " + new Date(urlConnection.getLastModified()));
                }
                if (urlConnection.getExpiration() != 0) {
                    System.out.println("Expiration date: " + new Date(urlConnection.getExpiration()));
                }
                if (urlConnection.getContentLength() != -1) {
                    System.out.println("Content-length: " + urlConnection.getContentLength());
                }
            } catch (MalformedURLException me) {
                System.err.println(args[i] + " is not a URL I understand");
            } catch (IOException ie) {
                System.err.println(ie);
            }
            System.out.println();
        }
    }

}
