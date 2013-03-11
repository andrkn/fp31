package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;


import datapackage.DataPackage;

public class PackageSender {
	
	private int serverPort;
	private String serverAdress;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public PackageSender() throws IOException{
		
		Properties prop = new Properties();
        InputStream in = PackageSender.class.getResourceAsStream("Properties.properties");
        prop.load(in);
        
        this.serverPort = Integer.parseInt((String) prop.get("serverPort"));
        this.serverAdress = (String)(prop.get("serverAdress"));
		
        Socket serverConnection = new Socket(InetAddress.getByName(this.serverAdress),this.serverPort);
        
        //Create outputstream for sending of packages
        OutputStream serverOutputStream = serverConnection.getOutputStream();
        oos = new ObjectOutputStream(serverOutputStream);
        
        //Create inputstream for receiving packages
      	InputStream clientInputStream = serverConnection.getInputStream();
      	ois = new ObjectInputStream(clientInputStream);
        
	}
	
	public void sendPackage(DataPackage pack){
		try {
			oos.writeObject(pack);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DataPackage receivePackage(){

		try {
			DataPackage pack = (DataPackage)ois.readObject();

			//Pack now contains the package that was received.
			return pack;

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
