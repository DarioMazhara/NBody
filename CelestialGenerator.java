package NBody2;

public class CelestialGenerator {
	public static Celestial createBody(String name, double mass, int x, int y, double xVel, double yVel, double size) {
		return new Celestial(name, mass, x, y, xVel, yVel, size);
	}
	
}
