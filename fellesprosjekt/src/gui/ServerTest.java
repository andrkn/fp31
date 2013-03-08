package gui;

import java.io.IOException;

import net.PackageReceiver;
import datapackage.DataPackage;
import datapackage.LoginPackage;

public class ServerTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		PackageReceiver rec = new PackageReceiver();
		while (true){
		DataPackage pack = rec.receivePackage();
		LoginPackage logpack = (LoginPackage)pack;
		System.out.println(logpack.getPassword());
		}

	}

}
