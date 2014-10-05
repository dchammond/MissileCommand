package com.DillonHammond.MissileCommand;

import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

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
	private static Color cityColor;
	private static double cityPosX;
	private static double cityPosY;
	private static double cityWidth;
	private static double cityHeight;
	private static final double ANGLE = -180.0;

	public PassiveBase(Color baseColor, Color cityColor, int screenWidth, int screenHeight) {
		// Get screen values
		this.screenWidth = (double) screenWidth;
		this.screenHeight = (double) screenHeight;
		// Start base creation
		this.baseColor = baseColor;
		this.basePosX = (this.screenWidth / 9.0); // Each base is a 9th of the screen across
		this.basePosY = (this.screenHeight / 6.0); // Each base is a 6th of the screnn in height
		this.baseWidth = this.basePosX; // This is just for better name clarification
		this.baseHeight = this.basePosY; // This is just for better name clarification
		// Start city creation
		this.cityColor = cityColor;
		this.cityPosX = this.basePosX; // X coord of a city's rect frame is same as its base
		this.cityPosY = (5.0*this.basePosY) - 35.0; // Top of a city is above the base by 35px (this is due to the screen menu bar taking up some pixels)
		this.cityWidth = this.baseWidth; // For better readability
		this.cityHeight = (this.basePosY/2.0); // Height of a city is half that of the base
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

	public static Arc2D.Double[] makeCities() {
		// City dimensions are in a rect that is the same width as a base but half as tall
		// City positions are multiplied to match the base they rest upon
		// ANGLE is -180.0 because this draws a hemisphere
		// Arc2D.CHORD allows the hemisphere's bottom to be a straight line
		Arc2D.Double[] listOfCities = {
		   new Arc2D.Double(1.0*cityPosX, cityPosY, cityWidth, cityHeight, ANGLE, ANGLE, Arc2D.CHORD),
		   new Arc2D.Double(2.0*cityPosX, cityPosY, cityWidth, cityHeight, ANGLE, ANGLE, Arc2D.CHORD),
		   new Arc2D.Double(3.0*cityPosX, cityPosY, cityWidth, cityHeight, ANGLE, ANGLE, Arc2D.CHORD),
		   new Arc2D.Double(5.0*cityPosX, cityPosY, cityWidth, cityHeight, ANGLE, ANGLE, Arc2D.CHORD),
		   new Arc2D.Double(6.0*cityPosX, cityPosY, cityWidth, cityHeight, ANGLE, ANGLE, Arc2D.CHORD),
		   new Arc2D.Double(7.0*cityPosX, cityPosY, cityWidth, cityHeight, ANGLE, ANGLE, Arc2D.CHORD)
		};
		return listOfCities;
	}

	public static void draw(Graphics2D g2) {
		Rectangle2D.Double[] allTheBases = makeBases();
		Arc2D.Double[] allTheCities = makeCities();

		g2.setColor(baseColor);
		for (int i = 0; i < 6; i++) {
			g2.draw(allTheBases[i]);
			g2.fill(allTheBases[i]);
		}

		g2.setColor(cityColor);
		for (int i = 0; i < 6; i++) {
			g2.draw(allTheCities[i]);
			g2.fill(allTheCities[i]);
		}
	}
}
