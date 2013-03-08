package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.PackageSender;

import datapackage.LoginPackage;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	private JTextField username, password;
	private JButton login;
	
	public LoginPanel(){
		username = new JTextField();
		username.setName("username");
		username.setColumns(30);
		add(username);
		
		password = new JTextField();
		password.setName("password");
		password.setColumns(30);
		add(password);
		
		login = new JButton();
		login.setName("login");
		login.setText("Login");
		login.addActionListener(new loginAction());
		add(login);
	}
	
	public class loginAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (username.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Username may not be blank");
			}
			else if (password.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Password may not be blank");			}
			else{
				LoginPackage loginPack = new LoginPackage(username.getText(), password.getText());
				PackageSender sender;
				try {
					sender = new PackageSender();
					sender.sendPackage(loginPack);
				} catch (IOException e1) {
					System.out.println("Could not send loginPackage to server");
					e1.printStackTrace();
				}
			}
			
		}
		
	}
}
