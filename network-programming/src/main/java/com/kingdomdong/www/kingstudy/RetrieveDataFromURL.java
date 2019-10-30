package com.kingdomdong.www.kingstudy;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class RetrieveDataFromURL {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.lolcats.com");
            InputStream inputStream = url.openStream();
            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.write(c);
            }
            inputStream.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
    
    /**
     * contents:
     * <!DOCTYPE html>
     * <html lang="en">
     *   <head>
     *     <!-- rendered: 12:00:19 10-05-2018 -->
     *     <meta charset="utf-8">
     *     <title>LOLCats - Funny cat pictures</title>
     *     <link rel="alternate" type="application/rss+xml" title="Lolcats RSS - Daily Funny Cat Pictures" href="http://feeds.feedburner.com/lolcats/rss">
     *     <meta property="fb:app_id" content="129294947206929"/>
     *     <meta property="og:title" content="LOLCats.com - Funny cat pictures"/>
     *     <meta property="og:site_name" content="LOLCats.com"/>
     *    
     *    
     *     <meta property="og:image" content="http://www.lolcats.com/images/logo.png"/>
     *    
     *     <meta property="fb:page_id" content="271571096186890"/>
     *     <meta name="keywords" content="lolcats, lol, funny, cats, cat pictures, cute, meme, cheezburger,
     *     ... 
     */
    public static void disposePatternOpenStream(){
        
    }

}
