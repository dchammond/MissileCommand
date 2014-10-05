package com.DillonHammond.MissileCommand;

import java.awt.geom.Line2D;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Created by Dillon on 10/4/14.
 */
public class ActiveTurret {

	private static Color turretColor;
	private static double screenWidth;
	private static double screenHeight;
	private static double numOfLines;
	private static final double LINE_WIDTH = 1.0;
	private static double lineLength;
	private static double turretHeight;
	private static double turretWidth;


	public ActiveTurret(Color turretColor, int screenWidth, int screenHeight) {
		// Get screen values
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		// Start turret creation
		this.turretColor = turretColor;
		this.turretHeight = ((this.screenHeight/6.0)/2.0); // The turret will be half of the base height (screenHeight/6.0)
		this.turretWidth = (this.screenWidth/9.0); // The turret will be as wide as the base
		this.numOfLines = (int) this.turretHeight; // We can't have .2 lines, there are as many lines as the turret height)
		this.lineLength = this.turretWidth;
	}

}
