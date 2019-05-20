package com.kingdomdong.www.chap7.url.connection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class EncodingAwareSourceView {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                // set default encoding
                String encoding = "ISO-8859-1";
                URL url = new URL(args[i]);
                URLConnection urlConnection = url.openConnection();
                String contentType = urlConnection.getContentType();
                int encodingStart = contentType.indexOf("charset=");
                if (encodingStart != -1) {
                    encoding = contentType.substring(encodingStart + 8);
                }
                InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                Reader reader = new InputStreamReader(inputStream, encoding);
                int c;
                while ((c = reader.read()) != -1) {
                    System.out.print((char)c);
                }
                reader.close();
            } catch (MalformedURLException e) {
                System.err.println(args[0] + " is not a parseable RUL");
            } catch (UnsupportedEncodingException e) {
                System.err.println("Server sent an encoding Java does not support: " + e.getMessage());
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
    
}
