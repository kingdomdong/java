package com.kingdomdong.www.cookie;

import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;

public class NoGovernmentCookies implements CookiePolicy {

    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        if (uri.getAuthority().toLowerCase().endsWith("org")
                || cookie.getDomain().toLowerCase().endsWith("org")) {
            return false;
        }
        
        return true;
    }
    
}
