package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import com.sun.org.apache.xalan.internal.xsltc.dom.AbsoluteIterator;

import model.Event;
import model.EventModel;
import model.Person;

public class CalendarDayPanel extends JPanel{
	
	public CalendarDayPanel(ArrayList<Event> events, int width, int height){
		
		
		this.setLayout(new GridBagLayout());
		this.setLayout(null);
		
		for (Event event : events){
			JPanel eventPanel = new EventPreview(new EventModel(event, new Person()));
			this.add(eventPanel);
			System.out.println(height/24);
			
			eventPanel.setBounds(0, (int)(height/24)*event.getStartTime().getHours(), (int)width,70);
		}
		this.validate(); 
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		// fill with the color you want
		int wide = getWidth();
		int tall = getHeight();
		g.setColor(new Color(240,240,240));
		g.fillRect(0, 0, wide, tall);

		// go into Graphics2D for all the fine art, more options
		// optional, here I just get variable Stroke sizes
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);

		g2.setStroke(new BasicStroke(1));
		g2.drawLine(0, 0, 0, tall);

		g2.setColor(Color.BLACK);
		double rowH = getHeight() / 24;
		for (int i = 1; i < 24; i++) {
			Line2D line = new Line2D.Double(0.0, (double) i * rowH,
					(double) getWidth(), (double) i * rowH);
			g2.draw(line);
		}

	}
	
}
