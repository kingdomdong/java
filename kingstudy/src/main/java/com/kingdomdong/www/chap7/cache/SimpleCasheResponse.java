package com.kingdomdong.www.chap7.cache;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheResponse;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SimpleCasheResponse extends CacheResponse {

    private final Map<String, List<String>> headers;
    private final SimpleCacheRequest request;
    private final Date expires;
    private final CacheControl control;

    public SimpleCasheResponse(SimpleCacheRequest request, URLConnection connection, CacheControl control)
            throws IOException {
        this.request = request;
        this.control = control;
        this.expires = new Date(connection.getExpiration());
        this.headers = Collections.unmodifiableMap(connection.getHeaderFields());
    }

    @Override
    public InputStream getBody() {
        return new ByteArrayInputStream(request.getData());
    }

    @Override
    public Map<String, List<String>> getHeaders() throws IOException {
        return headers;
    }

    public CacheControl getControl() {
        return control;
    }

    public boolean isExpired() {
        Date now = new Date();
        if (control.getMaxAge().before(now)) {
            return true;
        } else if (expires != null && control.getMaxAge() != null) {
            return expires.before(now);
        } else {
            return false;
        }

    }

}
