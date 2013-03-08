package net;

import java.io.IOException;
import java.io.InputStream;
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

	public PackageSender() throws IOException{
		
		Properties prop = new Properties();
        InputStream in = PackageSender.class.getResourceAsStream("Properties.properties");
        prop.load(in);
        
        this.serverPort = Integer.parseInt((String) prop.get("serverPort"));
        this.serverAdress = (String)(prop.get("serverAdress"));
		
        Socket serverConnection = new Socket(InetAddress.getByName(this.serverAdress),this.serverPort);
        OutputStream serverOutputStream = serverConnection.getOutputStream();
        oos = new ObjectOutputStream(serverOutputStream);
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
	
}
