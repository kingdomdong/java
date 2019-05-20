package com.kingdomdong.www.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @see https://docs.oracle.com/javase/tutorial/networking/sockets/examples/EchoClient.java
 * @author 0049002907
 * @since 2019.01.23
 * cmd - java com.kingdomdong.www.socket.EchoClient localhost 7
 */
public class EchoClient {
    
    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.err.println("Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        final String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // the method readLine waits until the server echoes the information back to EchoClient
                        try {
                            System.out.println(                         
                                            "  _____                            \n" +
                                            " / ____|                         _ \n" +
                                            "| (___   ___ _ ____   _____ _ __(_)\n" +
                                            " \\___ \\ / _ \\ '__\\ \\ / / _ \\ '__| \n" +
                                            " ____) |  __/ |   \\ V /  __/ |   _ \n" +
                                            "|_____/ \\___|_|    \\_/ \\___|_|  (_)\n"
                                    + in.readLine());
                        } catch (IOException e) {
                            System.err.println("Couldn't get I/O for the connection to " + hostName); // must be final hostName
                        }
                    }
                }).start();
            }
        } catch (UnknownHostException ex) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        }
    }
    
}
