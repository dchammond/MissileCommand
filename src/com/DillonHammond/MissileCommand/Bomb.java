package com.DillonHammond.MissileCommand;

import java.awt.geom.Line2D;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Dillon on 10/7/14.
 */
public class Bomb {

	private static Color bombColor;
	private static ArrayList<Line2D.Double> bombs = new ArrayList<Line2D.Double>();
	private static Random generator = new Random();
	private static int random;
	private static int randomTurret;
	private static double screenWidth;
	private static double screenHeight;
	private static double[] validBombCreation = new double[]{0.0,0.0};

	public Bomb(Color bombColor, double screenWidth, double screenHeight) {
		this.bombColor = bombColor;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.validBombCreation[0] = this.screenWidth;
		this.validBombCreation[1] = this.screenHeight / 3.0;
	}

	public static ArrayList<Line2D.Double> makeBombs() {
		random = generator.nextInt(10);
		randomTurret = generator.nextInt(6);
		double[] origin = {validBombCreation[0]/random, validBombCreation[1]/random};
		double[] end = {PassiveCity.listOfCities.get(randomTurret).getX(), PassiveCity.listOfCities.get(randomTurret).getY()};
		if (random >= 3) {
			bombs.add(new Line2D.Double(validBombCreation[0]/random, validBombCreation[1]/random, end[0], end[1]));
		}

		return bombs;
	}

	public static void draw(Graphics2D g2) {
		ArrayList<Line2D.Double> bombs = makeBombs();

		g2.setColor(bombColor);
		for (int i = 0; i < bombs.size(); i++) {
			g2.draw(bombs.get(i));
			g2.fill(bombs.get(i));
		}
	}
}
