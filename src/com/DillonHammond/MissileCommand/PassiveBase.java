package com.DillonHammond.MissileCommand;

import java.awt.geom.Rectangle2D;
import java.awt.Color;

/**
 * Created by Dillon on 10/4/14.
 */
public class PassiveBase {

	private static int numOfBases;
	private static Color baseColor;
	private static double baseWidth;
	private static double baseHeight;
	private static double screenWidth;
	private static double screenHeight;

	public PassiveBase(Color baseColor, int screenWidth, int screenHeight) {
		this.numOfBases = 6;
		this.baseColor = baseColor;
		this.screenWidth = (double) screenWidth;
		this.screenHeight = (double) screenHeight;
		this.baseWidth = (this.screenWidth / 6.0);
		this.baseHeight = (this.screenHeight / 6.0);
	}

	public static Rectangle2D.Double[] makeBases() {
		Rectangle2D.Double[] listOfBases = (new Rectangle2D.Double(100d, 500d, 100d, 100d),
											new Rectangle2D.Double(200d, 500d, 100d, 100d),
											new Rectangle2D.Double(300d, 500d, 100d, 100d),
											new Rectangle2D.Double(500d, 500d, 100d, 100d),
											new Rectangle2D.Double(600d, 500d, 100d, 100d),
											new Rectangle2D.Double(700d, 500d, 100d, 100d)
											);
		return listOfBases;
	}
}
