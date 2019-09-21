package com.kingdomdong.www.chap7.cache;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

/**
 * A basic CacheRequest subclass that passes back a ByteArrayOutputStream.
 * @author 0049002907
 *
 */
public class SimpleCacheRequest extends CacheRequest {

    private ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    
    
    @Override
    public OutputStream getBody() throws IOException {
        return out;
    }
    
    @Override
    public void abort() {
        out.reset();
    }
    
    public byte[] getData() {
        if (out.size() == 0) {
            return null;
        }
        return out.toByteArray();
    }
    
}
