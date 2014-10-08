package com.DillonHammond.MissileCommand;

import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Dillon on 10/7/14.
 */
public class Stars {

	private static final Color STAR_COLOR = new Color(255, 255, 255);
	private static double screenWidth;
	private static double screenHeight;
	private static ArrayList<Ellipse2D.Double> stars = new ArrayList<Ellipse2D.Double>();
	private static Random generator;

	public Stars(double screenWidth, double screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.generator = new Random();
	}

	private static void makeStars(int numOfStars) {
		for (int i = 0; i < numOfStars; i++) {
			int xCoord = generator.nextInt((int) (screenWidth - 50.0));
			int yCoord = generator.nextInt((int) (screenHeight / 3.0));
			stars.add(new Ellipse2D.Double(xCoord, yCoord, 10, 10));
		}
	}

	public static void draw(Graphics2D g2) {
		int numOfStars = 20;
		makeStars(numOfStars);

		g2.setColor(STAR_COLOR);
		for (int i = 0; i < numOfStars; i++) {
			g2.draw(stars.get(i));
			g2.fill(stars.get(i));
		}
	}
}
