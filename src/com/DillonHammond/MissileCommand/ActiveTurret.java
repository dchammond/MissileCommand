package com.DillonHammond.MissileCommand;

//import java.awt.geom.Line2D;
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
	private static double turretHeight;
	private static double turretWidth;
	private static Trapezoid turrets;

	public ActiveTurret(Color turretColor, double screenWidth, double screenHeight) {
		// Get screen values
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		// Start turret creation
		this.turretColor = turretColor;
		this.turretHeight = ((this.screenHeight/6.0)/2.0); // The turret will be half of the base height (screenHeight/6.0)
		this.turretWidth = (this.screenWidth/9.0); // The turret will be as wide as the base
		this.numOfLines = (int) this.turretHeight; // We can't have .2 lines, there are as many lines as the turret height)
		this.turrets = new Trapezoid(Color.YELLOW, this.turretWidth, (5.0*(this.screenHeight/6.0))-50.0, turretHeight, (0.0*turretWidth));
	}

	public static void draw(Graphics2D g2) {
		turrets.makeTrap(g2);
	}
}
