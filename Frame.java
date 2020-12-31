package NBody2;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Frame extends JFrame {
	CelestialSystem g;

	
	public Frame(List data) {
		this.setSize(768, 768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		g = new CelestialSystem(data);
		this.add(g);
		this.setVisible(true);
		
	
	
	
	}
}
