package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import datapackage.LoginPackage;

class doComms implements Runnable {
    private Socket clientSocket;
    private int connectionId;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

    doComms(Socket socket, int id) {
      this.clientSocket = socket;
      this.connectionId = id;
    }

	public void run () {

      try {
    	//Create inputstream for reading of packages
  		InputStream clientInputStream = clientSocket.getInputStream();
  		ois = new ObjectInputStream(clientInputStream);
  		
  		//Create outputstream for sending of packages
  		OutputStream serverOutputStream = clientSocket.getOutputStream();
        oos = new ObjectOutputStream(serverOutputStream);
        
        boolean isConnected = ! clientSocket.isClosed();
        
        while(isConnected) {
        	LoginPackage ph = (LoginPackage) ois.readObject();
        	System.out.println(ph.getPassword());
        	
        	closeStreams();
        	isConnected = ! clientSocket.isClosed();
        }
      } 
      
      catch (IOException ioe) {
        System.out.println("IOException on socket listen: " + ioe);
        ioe.printStackTrace();
      } 
      
      catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
	
	public void closeStreams() throws IOException {
		oos.close();
		ois.close();
		clientSocket.close();		
	}
}
