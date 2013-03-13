package gui;

import java.io.IOException;

import net.PackageReceiver;
import net.ServerPackageHandler;
import datapackage.DataPackage;
import datapackage.ErrorPackage;
import datapackage.ErrorType;
import datapackage.LoginPackage;

public class ServerTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		PackageReceiver rec = new PackageReceiver();
		boolean logedin = false;
		while (!logedin){
		DataPackage pack = rec.receivePackage();
		LoginPackage loginpack = (LoginPackage)pack;
		System.out.println(loginpack.getUsername());
		System.out.println(loginpack.getPassword());
		ServerPackageHandler handler = new ServerPackageHandler();
		DataPackage responsePack = handler.HandlePackage(loginpack);
		System.out.println(responsePack);
		ErrorPackage responsePack2 = (ErrorPackage)responsePack;
		System.out.println(responsePack2);
		System.out.println(responsePack2.getErrorType());
		System.out.println(responsePack2.getDescription());
		if (responsePack2.getErrorType()==ErrorType.OK){
			logedin = true;
		}	
		rec.sendPackage(responsePack);
		}

	}

}
