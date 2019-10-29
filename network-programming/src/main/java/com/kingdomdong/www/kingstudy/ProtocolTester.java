package com.kingdomdong.www.kingstudy;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * which protocol does a virtual machine support?
 * @author 0049002907
 *
 */
public class ProtocolTester {
    
    public static void main(String[] args) {
        
        // hypertext transfer protocol
        testProtocol("http://www.adc.org");
        
        // secure trip
        testProtocol("https://www.amazon.com/exec/exec/obdous/order2");
        
        // file transfer protocol
        testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq");
        
        // simple mail transfer protocol
        testProtocol("mailto:elharo@ibiblio.org");
        
        // telnet
        testProtocol("telnet://dibner.poly.edu");
        
        // local file access
        testProtocol("file:///etc/password");
        
        // gopher
        testProtocol("gopher://gopher.anc.org.za");
        
        // lightweight directory access protocol
        testProtocol("ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");
        
        // JAR
        testProtocol("jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!" +
                "/com/macfaq/io/StreamCompier.class");
        
        // NFS, network file system
        testProtocol("nfs://utopia.poly.edu/usr/tmp/");
        
        // a custom protocol for JDBC
        testProtocol("jdbc:mysql://luna.ibiblia.org:3306/NEWS");
        
        // rmi, a custom protocol to remote method innovation
        testProtocol("rmi://ibiblio/RenderEngine");
        
        // custom protocols for HotJava
        testProtocol("doc:/UserGuide/release.html");
        testProtocol("netdoc:/UserGuide/release.html");
        testProtocol("systemresource://www.adc.org/+/index.html");
        testProtocol("verbatim://www.adc.org/");
        
    }
    
    private static void testProtocol(String url) {
        try {
            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is supported");
        } catch (MalformedURLException mue) {
            String protocol = url.substring(0, url.indexOf(':'));
            System.out.println(protocol + " is not supported");
        }
    }

}
