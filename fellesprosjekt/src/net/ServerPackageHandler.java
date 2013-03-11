package net;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import datapackage.*;
import encryption.PasswordEncryption;


public class ServerPackageHandler {
	DataPackage pack;
	
	
	public void HandlePackage(DataPackage pack){
		if (this.pack instanceof LoginPackage){
			try {
				if (HandleLoginPackage(pack)){
					ErrorPackage errorPack = new ErrorPackage(ErrorType.OK,"All is well, user may pass");
					try {
						SendResponsePackage(errorPack);
					} catch (IOException e) {
						// Could not send response, client may have disconnected
						e.printStackTrace();
					}
				}
				else{
					ErrorPackage errorPack = new ErrorPackage(ErrorType.WRONG_PASSWORD,"The user SHALL NOT PASS");
					try {
						SendResponsePackage(errorPack);
					} catch (IOException e) {
						// Could not send response, client may have disconnected
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				// Good God, it crashed!
				e.printStackTrace();
			}
		}
	}


	private boolean HandleLoginPackage(DataPackage pack) throws IOException {
		//load properties
		Properties prop = new Properties();
        InputStream in = PackageSender.class.getResourceAsStream("Properties.properties");
        prop.load(in);
        //connect to DB
		DBConnection connection = new DBConnection(prop);
		connection.connect();
		Connection c = connection.getConnection();
		Statement s = connection.getStatement();
		DBMethods method = new DBMethods();
		method.setConnection(c);
		method.setStatement(s);
		
		//store pack as LoginPackage, must be checked before method is called
		LoginPackage loginpack = (LoginPackage)pack;
		//exec logincheck
		byte[] hash = null;
		byte[] salt = null;
		try{
			hash = method.getStoredHash(loginpack.getUsername(), "password");
			salt = method.getStoredHash(loginpack.getUsername(), "salt");
		}
		catch (SQLException e){
			//Something went horribly wrong in the DB
			e.printStackTrace();
		}
		
		if (PasswordEncryption.checkPassword(loginpack.getPassword(), hash, salt)){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	private void SendResponsePackage(DataPackage pack) throws IOException{
		PackageSender sender = new PackageSender();
		sender.sendPackage(pack);
		
	}
}
