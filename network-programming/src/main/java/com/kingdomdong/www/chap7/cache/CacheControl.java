package com.kingdomdong.www.chap7.cache;

import java.util.Date;
import java.util.Locale;

/**
 * Example 7-6 is a simple Java class for parsing and querying Cache-control headers.
 * How to inspect a cache-control header
 * HTTP/1.1 200 OK
 * Date: Sun, 21 Apr 2013 15:12:46 GMT
 * Server: Apache
 * Connection: close
 * Content-Type: text/html; charset=ISO-8859-1
 * Cache-control: max-age=604800
 * Expires: Sun, 28 Apr 2013 15:12:46 GMT
 * Last-modified: Sat, 20 Apr 2013 09:55:04 GMT
 * ETag: "67099097696afcf1b67e"
 * @author 0049002907
 * @since 2019.02.15
 */
public class CacheControl {

    private Date maxAge = null;
    
    // Number of seconds from now before the cached entry should expire from a shared
    // cache. Private caches can store the entry for longer.
    private Date sMaxAge = null;
    private boolean mustRevalidate = false;
    
    // The entry may still be cached, but the client should reverify the state of the
    // resource with an ETag or Last-modified header on each access.
    private boolean noCache = false;
    
    // Do not cache the entry no matter what.
    private boolean noStore = false;
    private boolean proxyRevalidate = false;
    
    // OK to cache an authenticated response. Otherwise authenticated responses are not
    // cached.
    private boolean publicCache = false;
    
    // Only single user caches should store the response; shared caches should not.
    private boolean privateCache = false;

    public CacheControl(String string) {
        if (string == null || !string.contains(":")) {
            return; // default policy
        }

        String value = string.split(":")[1].trim();
        String[] components = value.split(",");

        Date now = new Date();
        for (String component : components) {
            try {
                component = component.trim().toLowerCase(Locale.US);
                if (component.startsWith("max-age=")) {
                    int secondsInTheFuture = Integer.parseInt(component.substring(8));
                    maxAge = new Date(now.getTime() + 1000 * secondsInTheFuture);
                } else if (component.startsWith("s-maxage=")) {
                    int secondsInTheFuture = Integer.parseInt(component.substring(8));
                    sMaxAge = new Date(now.getTime() + 1000 * secondsInTheFuture);
                } else if (component.equals("must-revalidate")) {
                    mustRevalidate = true;
                } else if (component.equals("proxy-revalidate")) {
                    proxyRevalidate = true;
                } else if (component.equals("no-cache")) {
                    noCache = true;
                } else if (component.equals("public")) {
                    publicCache = true;
                } else if (component.equals("private")) {
                    privateCache = true;
                }
            } catch (RuntimeException re) {
                continue;
            }
        }
    }

    public Date getMaxAge() {
        return maxAge;
    }

    public Date getSharedMaxAge() {
        return sMaxAge;
    }

    public boolean mustRevalidate() {
        return mustRevalidate;
    }

    public boolean proxyRevalidate() {
        return proxyRevalidate;
    }

    public boolean noStore() {
        return noStore;
    }

    public boolean noCache() {
        return noCache;
    }

    public boolean publicCache() {
        return publicCache;
    }

    public boolean privateCache() {
        return privateCache;
    }

}
