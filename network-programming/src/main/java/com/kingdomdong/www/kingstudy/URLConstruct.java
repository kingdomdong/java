package com.kingdomdong.www.kingstudy;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConstruct {

    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            URL url = new URL("http://www.oreilly.org/");
            inputStream = url.openStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
            int c;
            while ((c = inputStreamReader.read()) != -1) {
                System.out.println((char) c);
            }
            
//            Object rst = url.getContent();
//            System.out.println(rst.getClass().getName());
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
    
}
