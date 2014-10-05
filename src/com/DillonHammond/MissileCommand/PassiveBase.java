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
		this.baseColor = baseColor;
		this.screenWidth = (double) screenWidth;
		this.screenHeight = (double) screenHeight;
		this.basePosX = (this.screenWidth / 9.0);
		this.basePosY = (this.screenHeight / 6.0);
		this.baseWidth = this.basePosX;
		this.baseHeight = this.basePosY;
	}

	public static Rectangle2D.Double[] makeBases() {
		// Rectangle dimensions are always 1/9 X 1/6 of the screen size
		// Rectangle locations are as follows: edge-->|T|x|x|x|T|x|x|x|T|<--edge (x is rect being drawn below, T is turret)
		Rectangle2D.Double[] listOfBases = (new Rectangle2D.Double(1.0*basePosX, 5.0*basePosY, baseWidth, baseHeight),
											new Rectangle2D.Double(2.0*basePosX, 5.0*basePosY, baseWidth, baseHeight),
											new Rectangle2D.Double(3.0*basePosX, 5.0*basePosY, baseWidth, baseHeight),
											new Rectangle2D.Double(5.0*basePosX, 5.0*basePosY, baseWidth, baseHeight),
											new Rectangle2D.Double(6.0*basePosX, 5.0*basePosY, baseWidth, baseHeight),
											new Rectangle2D.Double(7.0*basePosX, 5.0*basePosY, baseWidth, baseHeight)
											);
		return listOfBases;
	}

	public static void draw(Graphics2D g2) {

	}
}
