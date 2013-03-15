package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

import model.CalendarModel;
import model.Event;
import model.EventModel;
import model.Person;

public class CalendarPanel extends JPanel{

	CalendarModel model; 
	GridBagConstraints grid; 
	public static final long MILLISECOND_IN_DAY = 24*60*60*1000;
	
	public CalendarPanel(CalendarModel model){
		this.model = model; 
		this.setLayout(new GridBagLayout()); 
		this.setLayout(null);
		
//		update();
		System.out.println(this.getComponentCount());
		
//		this.setVisible(true);
//		this.setBackground(Color.BLUE); 
		this.validate(); 
		this.repaint();
	}
	
	public void update(){
		ArrayList<Event> events = model.getEventList();
//		JPanel eventPanel = new EventPreview(new EventModel(events.get(0), new Person()));
//		this.add(eventPanel);
//		eventPanel.setBounds(200, 200, 100, 100);
		
		Timestamp dayStart = model.getWeekStart();
		Timestamp dayEnd = new Timestamp(dayStart.getTime() + MILLISECOND_IN_DAY);
		
		int height = this.getHeight();
		int width = this.getWidth()/7;
		
		for (int i = 0; i < 7; i++){
			
			ArrayList<Event> eventsForDay = new ArrayList<Event>();
			
			for (Event event : events){
				if (event.getStartTime().after(dayStart) && event.getEndTime().before(dayEnd)){
					eventsForDay.add(event);
				}
			}
			
			JPanel dayPanel = new CalendarDayPanel(eventsForDay,width,height);
			this.add(dayPanel);
			dayPanel.setBounds(width*i, 0, width, height);
			
			Graphics g = this.getGraphics(); 
			g.drawLine(width*i, 0, width*i, height);
			this.paintComponents(g);
			
//			this.add(new DrawLine(width*i, 0, width*i, height, height));
			
			dayStart = dayEnd; 
			dayEnd = new Timestamp(dayStart.getTime() + MILLISECOND_IN_DAY);
			
//			Graphics line = new DebugGraphics(); 
//			line.drawLine(width*i, 0, width*i, height);
//			
			
//			System.out.println(width);
//			System.out.println(height);
		}
	}
	class DrawLine extends JPanel {
		
		int x1, y1, x2, y2, height;
		
		public DrawLine(int x1, int y1, int x2, int y2, int height){
			this.x1 = x1; 
			this.x2 = x2; 
			this.y1 = y1; 
			this.y2 = y2;
		}
		
		public Dimension getPreferredSize() {
			return new Dimension(1, height);
		}
		
		protected void paintComponent(Graphics g) {
	 
			g.setColor( Color.BLACK );
			// X Start, Y Start, X End, Y End
			// X = <---------->
			g.drawLine ( x1, y1, x2, y2 );
	 
		}
	}
	
}
