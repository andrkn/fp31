package gui;

import java.io.IOException;

import javax.swing.JFrame;

public class Main {

	public static void main(String args[]) {
		JFrame frame = new JFrame("Main");
		Main main = new Main();
		try {
			main.startLogIn(frame);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void startLogIn(JFrame frame) throws IOException, InterruptedException {
		LoginPanel pane = new LoginPanel();
		frame.getContentPane().add(pane);
		frame.pack();
		frame.setVisible(true);
		
		while (pane.isLoggedIn() == false) {
				System.out.println("waiting...");
		}
		System.out.println("done waiting!");
		frame.removeAll();
	}
	
}
