package com.kingdomdong.www.chap6.url.authenticator;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Test an basic authentication URL
 *      Perfect test web site - httpbin.org
 * @author 0049002907
 * @since 2019.01.22
 */
public class SecureSourceViewer {
    
    public static void main(String[] args) {
        Authenticator.setDefault(new DialogAuthenticator());
        // Example - http://kingdomdong:pass@httpbin.org/basic-auth/user/passwd
        for (int i = 0; i < args.length; i++) {
            try {
                // Open the URL for reading
                URL url = new URL(args[i]);
                try(InputStream in = new BufferedInputStream(url.openStream())) {
                    // chain the InputStream to a Reader
                    Reader reader = new InputStreamReader(in);
                    int c;
                    while((c = reader.read()) != -1) {
                        System.out.print((char)c);
                    }
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseble URL");
            } catch (IOException ex) {
                System.err.println(ex);
            }
            
            // print a blank line to separate pages
            System.out.println();
        }
        
        // Since we used the AWT, we have to explicitly exit.
        System.exit(0);
    }

}
