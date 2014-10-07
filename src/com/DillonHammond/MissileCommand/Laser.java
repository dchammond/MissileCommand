package com.DillonHammond.MissileCommand;

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

	public static Ellipse2D.Double makeExpolsion(double[] laserEnd) {
		double circleCenterX = laserEnd[0];
		double circleCenterY = laserEnd[1];
		double circleRadius = 25.0;
		double[] expolosionRectCoord = {circleCenterX - circleRadius, circleCenterY - circleRadius};
		Ellipse2D.Double explosion = new Ellipse2D.Double(expolosionRectCoord[0], expolosionRectCoord[1], circleRadius, circleRadius);

		return explosion;
	}
}
