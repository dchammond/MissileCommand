package com.DillonHammond.MissileCommand;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Created by Dillon on 10/4/14.
 */
public class PassiveBase {

	private static Color baseColor;
	private static double basePosX;
	private static double basePosY;
	private static double baseWidth;
	private static double baseHeight;
	private static double screenWidth;
	private static double screenHeight;

	public PassiveBase(Color baseColor, int screenWidth, int screenHeight) {
		// Get screen values
		this.screenWidth = (double) screenWidth;
		this.screenHeight = (double) screenHeight;
		// Start base creation
		this.baseColor = baseColor;
		this.basePosX = (this.screenWidth / 9.0); // Each base is a 9th of the screen across
		this.basePosY = (this.screenHeight / 6.0); // Each base is a 6th of the screen in height
		this.baseWidth = this.basePosX; // This is just for better name clarification
		this.baseHeight = this.basePosY; // This is just for better name clarification
	}

	public static ArrayList<Rectangle2D.Double> makeBases() {
		ArrayList<Rectangle2D.Double> listOfBases = new ArrayList<Rectangle2D.Double>();
		// Rectangle dimensions are always 1/9 X 1/6 of the screen size
		// Rectangles are placed at 5/6 of the screen's total height
		// Rectangle locations are as follows: edge-->|T|x|x|x|T|x|x|x|T|<--edge (x is rect being drawn below, T is turret being drawn)
		listOfBases.add(new Rectangle2D.Double(0.0 * basePosX, (5.0 * basePosY) - 50.0, baseWidth, (baseHeight + 50.0)));
		listOfBases.add(new Rectangle2D.Double(1.0 * basePosX, 5.0 * basePosY, baseWidth, baseHeight));
		listOfBases.add(new Rectangle2D.Double(2.0 * basePosX, 5.0 * basePosY, baseWidth, baseHeight));
		listOfBases.add(new Rectangle2D.Double(3.0 * basePosX, 5.0 * basePosY, baseWidth, baseHeight));
		listOfBases.add(new Rectangle2D.Double(4.0 * basePosX, (5.0 * basePosY) - 50.0, baseWidth, (baseHeight + 50.0)));
		listOfBases.add(new Rectangle2D.Double(5.0 * basePosX, 5.0 * basePosY, baseWidth, baseHeight));
		listOfBases.add(new Rectangle2D.Double(6.0 * basePosX, 5.0 * basePosY, baseWidth, baseHeight));
		listOfBases.add(new Rectangle2D.Double(7.0 * basePosX, 5.0 * basePosY, baseWidth, baseHeight));
		listOfBases.add(new Rectangle2D.Double(8.0 * basePosX, (5.0 * basePosY) - 50.0, baseWidth, (baseHeight + 50.0)));

		return listOfBases;
	}

	public static Line2D.Double[] makeLineDetails() {
		// Draws lines that will become windows in another function
		Line2D.Double[] allLines = {

		};
		return allLines;
	}

	public static void draw(Graphics2D g2) {
		ArrayList<Rectangle2D.Double> allTheBases = makeBases();

		g2.setColor(baseColor);
		for (int i = 0; i < 9; i++) {
			g2.draw(allTheBases.get(i));
			g2.fill(allTheBases.get(i));
		}
	}
}
