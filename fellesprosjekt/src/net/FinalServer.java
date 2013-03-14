package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FinalServer {

  private static int port=7899, maxConnections=0;
  // Listen for incoming connections and handle them
  public static void main(String[] args) {
    int i=0;

    try{
      ServerSocket serverSocket = new ServerSocket(port);
      Socket clientSocket;

      while((i++ < maxConnections) || (maxConnections == 0)){
//        doComms connection;

        clientSocket = serverSocket.accept();
        doComms conn_c= new doComms(clientSocket, i);
        Thread t = new Thread(conn_c);
        t.start();
      }
    } 
    
    catch (IOException ioe) {
      System.out.println("IOException on socket listen: " + ioe);
      ioe.printStackTrace();
    }
  }

}