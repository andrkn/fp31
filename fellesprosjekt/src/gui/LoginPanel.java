package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.PackageSender;

import datapackage.LoginPackage;

public class LoginPanel extends JPanel {
	private JTextField username, password;
	private JButton login;
	
	public LoginPanel(){
		
	}
	
	public class loginAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (username.getText().isEmpty()){
				//Ingen brukernavn angitt
			}
			else if (password.getText().isEmpty()){
				//Ingen passord angitt
			}
			else{
				LoginPackage loginPack = new LoginPackage(username.getText(), password.getText());
				PackageSender sender;
				try {
					sender = new PackageSender();
					sender.sendPackage(loginPack);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
	}
}
