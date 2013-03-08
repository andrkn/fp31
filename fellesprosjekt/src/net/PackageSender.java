package net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


import datapackage.DataPackage;

public class PackageSender {
	
	private int serverPort;
	private String serverAdress;

	public PackageSender(int serverPort, String serverAdress){
		this.serverPort = serverPort;
		this.serverAdress = serverAdress;
	}
	
	public void sendPackage(DataPackage pack){
		try {
			Socket serverConnection = new Socket(InetAddress.getByName(this.serverAdress),this.serverPort);
			OutputStream serverOutputStream = serverConnection.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(serverOutputStream);
			oos.writeObject(pack);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
