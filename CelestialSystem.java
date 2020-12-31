package NBody2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class CelestialSystem extends JPanel implements ActionListener {

	
	List bodies = new LinkedList();
	Timer timer = new Timer(100, this);
	int scale;
	
	
	public CelestialSystem(List data) {
		bodies = data;
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		System.out.println("paintComponent");
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
	//	Graphics2D g2D = (Graphics2D) g;
		
	//	g2D.setColor(Color.YELLOW);
		
		drawBodies(g);
		timer.start();
	}
	
	private void drawBodies(Graphics g) {
		System.out.println("drawBodies");
		
		for (int i = 0; i < bodies.size(); i++) {
			Random r = new Random();
		
			Celestial body = bodies.get(i);
			g.setColor(body.color);
			g.fillOval(body.x, body.y, (int)body.size, (int)body.size);
		}
	}
	
	private void update() {
		System.out.println("update");
		if (bodies.size() <= 1)
			return;
		
		for (int i = 0; i < bodies.size(); i++) {
			bodies.get(i).calcNetForce(bodies);
			bodies.get(i).update();
		}
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		update();
	}
	
}
