package com.DillonHammond.MissileCommand;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

/**
 * Created by Dillon on 10/4/14.
 */
public class PassiveCity {

	private static double screenWidth;
	private static double screenHeight;
	private static Color cityColor;
	private static double cityPosX;
	private static double cityPosY;
	private static double cityWidth;
	private static double cityHeight;
	private static final double ANGLE = -180.0;

	public PassiveCity(Color cityColor, int screenWidth, int screenHeight) {
		// Get screen values
		this.screenWidth = (double) screenWidth;
		this.screenHeight = (double) screenHeight;
		// Start city instantiation
		this.cityColor = cityColor;
		this.cityPosX = (this.screenWidth/9.0); // X coordinate of a city's rect frame is same as its base
		this.cityPosY = (5.0*(this.screenHeight/6.0)) - 35.0; // Top of a city is above the base by 35px (this is due to the screen menu bar taking up some pixels)
		this.cityWidth = this.cityPosX; // For better readability
		this.cityHeight = ((this.screenHeight/6.0)/2.0); // Height of a city is half that of the base
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
		Arc2D.Double[] allCities = makeCities();

		g2.setColor(cityColor);
		for (int i = 0; i < 6; i++) {
			g2.draw(allCities[i]);
			g2.fill(allCities[i]);
		}
	}
}
