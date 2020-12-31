package NBody2;

import java.awt.Color;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Scanner;


@SuppressWarnings("serial")
public class NBody extends JFrame {
	static String dataStructure;
	static List data;
	public static double scale;
	static Scanner scanner;
	static Frame frame;
	
	public static void main(String[] args) {
		
		
		scanner = new Scanner(System.in);
		
		System.out.println("ArrayList or LinkedList");
		dataStructure = scanner.nextLine().toLowerCase();
		System.out.println("Enter scale: ");
		scale = scanner.nextDouble();
		
		setDataStructure(dataStructure);
		populateDataStructure();
		createFrame();
		
		
		
	}
	private static void setDataStructure(String dataStructure) {
		if (dataStructure.equals("linkedlist")) {
			data = new LinkedList();
		}
		else {
			data = new ArrayListCustom();
		}
	}
	
	private static void populateDataStructure() {
		try {
			scanner = new Scanner(new File("CelestialBodies.csv"));
		} catch(FileNotFoundException e) {
			System.err.print("File not found");
		}
		
		boolean firstIteration = true;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (firstIteration) {
				firstIteration = false;
				continue;
			}
			String[] parts = line.split(",");
			String name = parts[0];
			Double mass = Double.parseDouble(parts[1]);
			int xcoord = Integer.parseInt(parts[2]);
			int ycoord = Integer.parseInt(parts[3]);
			Double xvel = Double.parseDouble(parts[4]);
			Double yvel = Double.parseDouble(parts[5]);
			Double size = Double.parseDouble(parts[6]);
			size = size * 1/scale;
			data.add(CelestialGenerator.createBody(name, mass, xcoord, ycoord, xvel, yvel, size));
		}
		System.out.println("End of populateDataStructure()");
		
	}
	
	private static void createFrame() {
		frame = new Frame(data);
	}

}
