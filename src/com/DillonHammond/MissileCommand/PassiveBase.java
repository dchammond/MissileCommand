package com.DillonHammond.MissileCommand;

import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Graphics2D;

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
		this.basePosY = (this.screenHeight / 6.0); // Each base is a 6th of the screnn in height
		this.baseWidth = this.basePosX; // This is just for better name clarification
		this.baseHeight = this.basePosY; // This is just for better name clarification
	}

	public static Rectangle2D.Double[] makeBases() {
		// Rectangle dimensions are always 1/9 X 1/6 of the screen size
		// Rectangles are placed at 5/6 of the screen's total height
		// Rectangle locations are as follows: edge-->|T|x|x|x|T|x|x|x|T|<--edge (x is rect being drawn below, T is turret)
		Rectangle2D.Double[] listOfBases = {
		   new Rectangle2D.Double(1.0 * basePosX, 5.0 * basePosY, baseWidth, baseHeight),
		   new Rectangle2D.Double(2.0 * basePosX, 5.0 * basePosY, baseWidth, baseHeight),
		   new Rectangle2D.Double(3.0 * basePosX, 5.0 * basePosY, baseWidth, baseHeight),
		   new Rectangle2D.Double(5.0 * basePosX, 5.0 * basePosY, baseWidth, baseHeight),
		   new Rectangle2D.Double(6.0 * basePosX, 5.0 * basePosY, baseWidth, baseHeight),
		   new Rectangle2D.Double(7.0 * basePosX, 5.0 * basePosY, baseWidth, baseHeight)
		};
		return listOfBases;
	}

	public static void draw(Graphics2D g2) {
		Rectangle2D.Double[] allTheBases = makeBases();

		g2.setColor(baseColor);
		for (int i = 0; i < 6; i++) {
			g2.draw(allTheBases[i]);
			g2.fill(allTheBases[i]);
		}
	}
}
