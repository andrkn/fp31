package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import datapackage.DataPackage;

public class PackageReceiver {
	
	private int port;
	private String serverAdress;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public PackageReceiver() throws IOException{
		Properties prop = new Properties();
        InputStream in = PackageReceiver.class.getResourceAsStream("Properties.properties");
        prop.load(in);
        
        this.port = Integer.parseInt((String) prop.get("serverPort"));
        this.serverAdress = (String)(prop.get("serverAdress"));
        
        serverSocket = new ServerSocket(this.port,50,InetAddress.getByName(this.serverAdress));
		clientSocket = serverSocket.accept();
		
		//Create inputstream for reading of packages
		InputStream clientInputStream = clientSocket.getInputStream();
		ois = new ObjectInputStream(clientInputStream);
		
		//Create outputstream for sending of packages
		OutputStream serverOutputStream = clientSocket.getOutputStream();
        oos = new ObjectOutputStream(serverOutputStream);
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
	
	public void sendPackage(DataPackage pack){
		try {
			oos.writeObject(pack);
		}
		catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() throws IOException{
		oos.close();
		ois.close();
		clientSocket.close();
		serverSocket.close();
	}
}