package com.kingdomdong.www.chap7.url.connection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Example 7-1 Download a web page with a URLConnection
 * @see  
 * @author 0049002907
 *
 */
public class SourceView2 {
    
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                // Open the URLConnection for reading
                URL url = new URL(args[0]);
                URLConnection urlConnection = url.openConnection();
                try (InputStream raw = urlConnection.getInputStream(); // autoclose
                        InputStream buffer = new BufferedInputStream(raw);
                        // chain the input to a Reader
                        Reader reader = new InputStreamReader(buffer)) {
                    int c;
                    while ((c = reader.read()) != -1) {
                        System.out.print((char)c);
                    }
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a pareable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

}
