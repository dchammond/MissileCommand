package com.DillonHammond.MissileCommand;

import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Created by Dillon on 10/5/14.
 */
public class Road {

	private static int screenWidth;
	private static int screenHeight;
	private static Color roadColor;
	private static Color dividerColor;
	private static Rectangle2D.Double road;
	private static double roadStartPosX;
	private static double roadStartPosY;
	private static double roadWidth;
	private static double roadHeight;
	private static ArrayList<Rectangle2D.Double> dividers = new ArrayList<Rectangle2D.Double>();
	private static double dividerWidth;
	private static double dividerHeight;
	private static double dividerPosX;
	private static double dividerPosY;
	private static int numOfDividers;

	public Road(int screenWidth, int screenHeight) {
		// Set screen values
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		// Set up colors
		this.roadColor = new Color(110, 110, 110);
		this.dividerColor = new Color(255, 250, 10);
		// Set up road values
		this.roadStartPosX = 0.0;
		this.roadStartPosY = this.screenHeight - 70.0; // The road will be the bottom 50px of the screen
		this.roadWidth = this.screenWidth; // Road crosses entire screen
		this.roadHeight = this.screenHeight - this.roadStartPosY;
		// This finds the values of height based on how far above the bottom of the screen the rect is
		// Set up divider values
		this.dividerWidth = this.screenWidth / 20.0; // 5 dividers for the screen
		this.dividerHeight = this.roadHeight / 6.0; // Divider will be 1/6 the width of the road
		this.dividerPosX = this.screenWidth / 20.0; // The dividers should be evenly spaced to fit 10
		this.dividerPosY = this.roadStartPosY + (70.0 / 3.0); // The top left of the rect will be at 1/3 of the road's height
		this.numOfDividers = (int) this.dividerWidth; // We want only int amount of dividers
	}

	public static Rectangle2D.Double makeRoad() {
		road = new Rectangle2D.Double(roadStartPosX, roadStartPosY, roadWidth, roadHeight);
		return road;
	}
	
	public static ArrayList<Rectangle2D.Double> makeDividers() {
		double x = 0.0;
		for (int i = 0; i < numOfDividers; i++) {
			dividers.add(new Rectangle2D.Double((x*dividerPosX) + dividerPosX, dividerPosY, dividerWidth, dividerHeight));
			x += 2.0;
			// We add x*dividerPosX because we want to space out the dividers
		}
		return dividers;
	}

	public static void draw(Graphics2D g2) {
		road = makeRoad();
		dividers = makeDividers();
		// Start road draw
		g2.setColor(roadColor);
		g2.draw(road);
		g2.fill(road);
		// Draw dividers
		g2.setColor(dividerColor);
		for (int i = 0; i < dividers.size(); i++) {
			g2.draw(dividers.get(i));
			g2.fill(dividers.get(i));
		}
	}
}
