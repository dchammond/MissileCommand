package com.DillonHammond.MissileCommand;

import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
import java.awt.Color;

/**
 * Created by Dillon on 10/7/14.
 */
public class Moon {

	private static final Color MOON_COLOR = new Color(255, 255, 255);
	private static Ellipse2D.Double moon;
	private static double screenWidth;
	private static double screenHeight;

	public Moon(double screenWidth, double screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}

	private static Ellipse2D.Double makeMoon() {
		double x = 850.0;
		double y = 100.0;
		double w = 100.0;
		double h = 100.0;
		moon = new Ellipse2D.Double(x, y, w, h);

		return moon;
	}

	public static void draw(Graphics2D g2) {
		moon = makeMoon();

		g2.setColor(MOON_COLOR);
		g2.draw(moon);
		g2.fill(moon);
	}
}
