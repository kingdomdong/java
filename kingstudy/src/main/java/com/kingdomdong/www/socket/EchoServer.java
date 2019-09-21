package com.kingdomdong.www.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @see https://docs.oracle.com/javase/tutorial/networking/sockets/examples/EchoServer.java
 * @author 0049002907
 * @since 2019.01.23
 * cmd - java com.kingdomdong.www.socket.EchoServer 7
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        final int portNumber = Integer.parseInt(args[0]); // 7

        try (ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("    _____ _ _            _   \n" +
                                     " / ____| (_)          | |\n"
                                  + "| |    | |_  ___ _ __ | |_\n" 
                                  + "| |    | | |/ _ \\ '_ \\| __|\n"
                                  + "| |____| | |  __/ | | | |_ \n"
                                  + " \\_____|_|_|\\___|_| |_|\\__| \n");
                System.out.println(inputLine);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String backContent;
                        try {
                            while ((backContent = stdIn.readLine()) != null) {
                                out.println(backContent);
                            }
                        } catch (IOException e) {
                            System.out.println("Exception caught when trying to listen on port " + portNumber // must be final portNumber
                                    + " or listening for a connection");
                            System.out.println(e.getMessage());
                        }
                    }
                }).start();
            }
        }
    }

}
