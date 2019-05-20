package com.kingdomdong.www.chap7.url.connection;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * command parameters: https://znvphotostore.oss-cn-shenzhen.aliyuncs.com/ywossandroidDEBUG-161969486_1527506277398_2
 * https://www.oreilly.com
 * @author 0049002907
 * @since 2019.01
 */
public class BinarySave {
    
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                URL url = new URL(args[i]);
                saveBinaryFiel(url);
            } catch (MalformedURLException e) {
                System.err.println(args[i] + " is not URL I understood.");
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
    
    public static void saveBinaryFiel(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        String contentType = urlConnection.getContentType();
        int contentLength = urlConnection.getContentLength();
        if (contentType.startsWith("text/") || contentLength == -1) {
            throw new IOException("This is not a binary file.");
        }
        
        try(InputStream raw = urlConnection.getInputStream()) {
            InputStream inputStream = new BufferedInputStream(raw);
            byte[] data = new byte[contentLength];
            int offset = 0;
            while(offset < contentLength) {
                int bytesRead = inputStream.read(data, offset, data.length - offset);
                if (bytesRead != -1) {
                    offset += bytesRead;
                }
            }
            
            if (offset != contentLength) {
                throw new IOException("Only read " + offset + " bytes; Expected " + contentLength + " bytes");
            }
            
            String filename = url.getFile();
            filename = filename.substring(filename.lastIndexOf('/') + 1);
            // FileOutputStream is meant for writing streams of raw types such as image data.
            // For writing streams of characters, consider using FileWriter. 
            try(FileOutputStream fout = new FileOutputStream(filename)) {
                fout.write(data);
                fout.flush();
            }
        }
    }

}
