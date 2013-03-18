package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FinalServer {
	
	//These variables sholud be read from the Properties.properties file..
	private static int port=7899, maxConnections=0;
 
	//This class listens for incoming connections and handle them in seperate threads
  	
	public static void main(String[] args) {
    int i=0;

    try{
    	//Creates the serversocket thats listens to the port for connections.
    	ServerSocket serverSocket = new ServerSocket(port);
    	Socket clientSocket;

      while((i++ < maxConnections) || (maxConnections == 0)){
    	  //Handles the incommimg connections and send them to a new thread.
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