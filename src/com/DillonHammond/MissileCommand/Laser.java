package com.DillonHammond.MissileCommand;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Created by Dillon on 10/6/14.
 */
public class Laser {

	private static Color laserColor;
	private static double screenWidth;
	private static double screenHeight;
	private static double x1;
	private static double x2;
	private static double y1;
	private static double y2;
	private static Line2D.Double laser;
	private static ArrayList<Ellipse2D.Double> laserOrigins = new ArrayList<Ellipse2D.Double>();

	public Laser(Color laserColor, ArrayList<Ellipse2D.Double> laserOrigins, double screenWidth, double screenHeight) {
		this.laserColor = laserColor;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.laserOrigins = laserOrigins;
	}

	public static Line2D.Double fireLaser(int turretNum, double[] whereMouseClicked) {
		double topLeftX = ActiveTurret.laserOrigins.get(turretNum).getX();
		double topLeftY = ActiveTurret.laserOrigins.get(turretNum).getY();
		double width = ActiveTurret.laserOrigins.get(turretNum).getWidth();
		double[] center = {topLeftX + width/2.0, topLeftY};
		laser = new Line2D.Double(center[0], center[1], whereMouseClicked[0], whereMouseClicked[1]);
		return laser;
	}
}
