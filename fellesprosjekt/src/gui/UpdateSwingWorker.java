package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class UpdateSwingWorker extends SwingWorker<Void, Void>{
	
	private JFrame frame;
	private JPanel pane;
	
	public UpdateSwingWorker(JPanel pane, JFrame frame){
		this.frame = frame;
		this.pane = pane;
	}

	@Override
	public Void doInBackground() {
		((MainCalendarPanel) pane).requestCalendar(((MainCalendarPanel) pane).getPerson().getUsername());
		return null;
	}

	@Override
	public void done() {
		pane.validate();
		pane.repaint();
	}
}
