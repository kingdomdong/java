package com.kingdomdong.www.url.encoder;

public class EncoderMain {
    
    public static void main(String[] args) {
        QueryString queryString = new QueryString();
        queryString.add("hl", "en");
        queryString.add("as_q", "Java");
        queryString.add("as_epq", "I/O");
        String url = "http://www.google.com/search?" + queryString;
        
        System.out.println(url);
    }
    
}
