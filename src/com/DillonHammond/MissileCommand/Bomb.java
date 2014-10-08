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
	private static double[] origin = new double[]{0.0,0.0};
	private static ArrayList<Double> endX = new ArrayList<Double>();
	private static ArrayList<Double> endY = new ArrayList<Double>();

	public Bomb(Color bombColor, double screenWidth, double screenHeight) {
		this.bombColor = bombColor;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.validBombCreation[0] = this.screenWidth;
		this.validBombCreation[1] = this.screenHeight / 5.0;
	}

	public static ArrayList<Line2D.Double> makeBombs(double[] amountDraw) {
		bombs.add(new Line2D.Double(origin[0], origin[1], amountDraw[0], amountDraw[1]));

		return bombs;
	}

	public static void generateRandomValues() {
		random = generator.nextInt(15);

		if (random == 0.0) {
			random++;
		}
		randomTurret = generator.nextInt(6);
		origin[0] = 2.0*validBombCreation[0]/random;
		origin[1] = validBombCreation[1]/random;
		if (2.0*validBombCreation[0]/random >= screenWidth) {
			origin[0] = screenWidth - 10.0;
		}
		double finalEndX = PassiveCity.listOfCities.get(randomTurret).getX() + screenWidth/18.0;
		double finalEndY = PassiveCity.listOfCities.get(randomTurret).getY() + 10.0;
		for (double i = 0.0; i <=1.0 ; i += 0.1) {
			endX.add(finalEndX*i);
			endY.add(finalEndY*i);
		}
	}

	public static void draw(Graphics2D g2) {
		double percentDraw = 0.0;
		generateRandomValues();

		for (int i = 0; i < endX.size(); i++) {
			double[] amountDraw = {endX.get(i), endY.get(i)};
			bombs = makeBombs(amountDraw);
		}

		g2.setColor(bombColor);
		for (int i = 0; i < bombs.size(); i++) {
			g2.draw(bombs.get(i));
			g2.fill(bombs.get(i));
		}
		bombs.clear();
	}
}
