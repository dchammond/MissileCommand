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
	private static double turretHeight;
	private static double turretWidth;

	public ActiveTurret(Color turretColor, double screenWidth, double screenHeight) {
		// Get screen values
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		// Start turret creation
		this.turretColor = turretColor;
		this.turretHeight = ((this.screenHeight/6.0)/2.0); // The turret will be half of the base height (screenHeight/6.0)
		this.turretWidth = (this.screenWidth/9.0); // The turret will be as wide as the base
	}

	public static void draw(Graphics2D g2) {
		double x = 0.0;
		for (int i = 0; i < 3; i++) {
			Trapezoid turret = new Trapezoid(turretColor, turretWidth, (5.0*(screenHeight/6.0))-50.0, turretHeight, (x*turretWidth));
			turret.makeTrap(g2);
			x += 4.0;
		}
	}
}
