package gui;

import java.io.IOException;

import javax.swing.JFrame;

import datapackage.DataPackage;
import datapackage.LoginPackage;

import net.PackageReceiver;

public class GuiTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
			JFrame frame = new JFrame("Login");
			frame.getContentPane().add(new LoginPanel());
			frame.pack();
			frame.setVisible(true);
			
//			PackageReceiver rec = new PackageReceiver();
//			DataPackage pack = rec.receivePackage();
//			LoginPackage logpack = (LoginPackage)pack;
//			System.out.println(logpack.getPassword());
			
	}
}
