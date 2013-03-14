package gui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel {

	private static Boolean isRunning = true;
	private static JPanel pane;
	private static JFrame frame;
	
	public static void main(String args[]) {
		frame = new JFrame("Calendar");
		//frame.setAlwaysOnTop(true);
		//Centering the frame on the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
		Point newLocation = new Point(middle.x - (400 / 2), middle.y - (115 / 2));
		frame.setLocation(newLocation);
		//Exit on close
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		MainPanel mainPanel = new MainPanel();
		
		//Starting the login-process
		try {
			startLogIn(frame, mainPanel);
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
	
	private static void startLogIn(JFrame frame, MainPanel mainPanel) throws IOException, InterruptedException {
		pane = new LoginPanel(mainPanel);
		frame.getContentPane().add(pane);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false); 
	}
	
	public void loginApproved(String username) {
		pane.removeAll();
		pane.updateUI();
		constructCalender(username);
	}
	
	public static void constructCalender(String username){
		pane = new MainCalendarPanel(username);
		frame.getContentPane().add(pane);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setSize(800, 800);
		pane.validate();
		pane.repaint();
		frame.validate();
		frame.repaint();
		
		
	}
	
}
