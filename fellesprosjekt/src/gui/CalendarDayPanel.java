package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Event;
import model.EventModel;
import model.Person;

public class CalendarDayPanel extends JPanel{
	
	private String[] days = {
			"Mandag", 
			"Tirdsag", 
			"Onsdag", 
			"Torsdag", 
			"Fredag", 
			"Lørdag",
			"Søndag"
	};
	
	public CalendarDayPanel(ArrayList<Event> events, int width, int height,int day, MainCalendarPanel mainPanel){
		
		this.setLayout(null);
		
		JLabel dayLabel = new JLabel(days[day]);
		this.add(dayLabel); 
		dayLabel.setBounds(3, 10, width-10, 15);
		
		for (Event event : events){
			JPanel eventPanel = new EventPreview(new EventModel(event, new Person()), mainPanel);
			this.add(eventPanel);
			
			eventPanel.setBounds(0, 30 + (int)(height/24)*event.getStartTime().getHours(), (int)width,70);
		}
		this.validate(); 
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		// fill with the color you want
		int wide = getWidth();
		int tall = getHeight();
		int color = 238;
		g.setColor(new Color(color,color,color));
		g.fillRect(0, 0, wide, tall);

		// go into Graphics2D for all the fine art, more options
		// optional, here I just get variable Stroke sizes
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);

		g2.setStroke(new BasicStroke(1));
		g2.drawLine(0, 0, 0, tall);
		g2.drawLine(wide, 0, wide, tall);

		g2.setColor(Color.BLACK);
		double rowH = tall / 24;
		for (int i = 0; i < 24; i++) {
			Line2D line = new Line2D.Double(0.0, 30 + (double) i * rowH,
					(double) getWidth(), 30 + (double) i * rowH);
			g2.draw(line);
		}

	}
	
}
