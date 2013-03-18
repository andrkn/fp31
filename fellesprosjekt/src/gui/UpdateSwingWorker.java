package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;


public class UpdateSwingWorker extends SwingWorker<Void, Void>{
	
	private JFrame frame;
	private JPanel pane;
	private CalendarPanel panel;
	
	public UpdateSwingWorker(JPanel pane, JFrame frame, CalendarPanel panel){
		this.frame = frame;
		this.pane = pane;
		this.panel = panel;
	}

	@Override
	public Void doInBackground() {
		while (true) {
			panel.setModel(((MainCalendarPanel) pane).requestCalendar(((MainCalendarPanel) pane).getPerson().getUsername()));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void done() {
		
	}
}
