package NBody2;

import java.awt.Color;

public class Celestial {
	public static final double GRAV_CONST = 6.67 * Math.pow(10, -11);
	
	String name;
	double mass;
	int x, y;
	double xVel, yVel;
	double size;
	double netX;
	double netY;
	Color color;
	
	public Celestial(String name, double mass, int x, int y, double xVel, double yVel, double size) {
		this.name = name;
		this.mass = mass;
		this.x = x;
		this.y = y;
		this.xVel = xVel;
		this.yVel = yVel;
		this.size = size;
		this.color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	}

	
	public double calcDistance(Celestial body) {	
		return Math.sqrt(Math.pow(body.x-this.x, 2) + Math.pow(body.y-this.y, 2));
	}
	
	public double calcForce(Celestial body) {
		return (GRAV_CONST*this.mass*body.mass)/Math.pow(calcDistance(body), 2);
	}
	
	public double calcForceX(Celestial body) {
		return (calcForce(body) * (this.x-body.x))/calcDistance(body);
	}
	
	public double calcForceY(Celestial body) {
		return (calcForce(body) * (this.y-body.y))/calcDistance(body);
	}
	
	public void calcNetForce(List bodies) {
		for (int i = 0; i < bodies.size(); i++) {
			if (bodies.get(i) == this)
				continue;
			Celestial x = bodies.get(i);
			
			this.netX += this.calcForceX(x);
			this.netY += this.calcForceY(x);
		}
	}
	
	public void update() {
		double xAccel = this.netX/this.mass;
		double yAccel = this.netY/this.mass;
		this.xVel += xAccel;
		this.yVel += yAccel;
		
		this.x += this.xVel;
		this.y += this.yVel;
		
		this.netX = 0;
		this.netY = 0;
	}
	
}
