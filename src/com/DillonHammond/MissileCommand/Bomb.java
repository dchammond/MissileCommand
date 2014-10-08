package com.DillonHammond.MissileCommand;

import java.awt.geom.Line2D;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private static double finalEndX;
	private static double finalEndY;
	private static double distX;
	private static double distY;
	private static Timer timer;

	public Bomb(Color bombColor, double screenWidth, double screenHeight) {
		this.bombColor = bombColor;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.validBombCreation[0] = this.screenWidth;
		this.validBombCreation[1] = this.screenHeight / 5.0;
	}

	public static ArrayList<Line2D.Double> makeBombs(double amountDrawX, double amountDrawY) {
		bombs.add(new Line2D.Double(origin[0], origin[1], amountDrawX, amountDrawY));

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
		finalEndX = PassiveCity.listOfCities.get(randomTurret).getX() + screenWidth/18.0;
		finalEndY = PassiveCity.listOfCities.get(randomTurret).getY() + 10.0;
		distX = finalEndX - origin[0];
		distY = finalEndY - origin[1];
		for (double i = distX; i > 0; i--) {
			endX.add(finalEndX - i);
		}
		for (double i = distY; i > 0; i--) {
			endY.add(finalEndY - i);
		}
	}

	public static void makeTimer() {
		timer = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello");
			}
		});
		timer.setInitialDelay(0);
		timer.start();
	}

	public static void draw(Graphics2D g2) {
		generateRandomValues();
		double amountDrawX = 0.0;
		double amountDrawY = 0.0;

		for (int i = 0; i < endX.size(); i++) {
			amountDrawX = endX.get(i);
		}

		for (int i = 0; i < endY.size(); i++) {
			amountDrawY = endY.get(i);
		}

		bombs = makeBombs(amountDrawX, amountDrawY);

		g2.setColor(bombColor);
		for (int i = 0; i < bombs.size(); i++) {
			g2.draw(bombs.get(i));
			g2.fill(bombs.get(i));
		}
		bombs.clear();
		endX.clear();
		endY.clear();
	}
}
