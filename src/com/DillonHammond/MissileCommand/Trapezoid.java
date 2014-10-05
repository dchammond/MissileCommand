package com.DillonHammond.MissileCommand;

import java.awt.geom.Line2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Created by Dillon on 10/4/14.
 */
public class Trapezoid {

	private static Color lineColor;
	private static double numOfLines;
	private static double lineLength;
	private static double trapHeight;
	private static double trapBaseWidth;
	private static double trapBaseY;
	private static double trapTopWidth;
	private static double lineStartPosX;
	private static double lineEndPosX;
	private static ArrayList<Line2D.Double> lines = new ArrayList<Line2D.Double>();

	public Trapezoid(Color lineColor, double trapBaseWidth, double trapTopWidth, double trapBaseY, double trapHeight, double lineStartPosX, double lineEndPosX) {
		this.lineColor = lineColor;
		this.trapBaseWidth = trapBaseWidth;
		this.trapTopWidth = trapTopWidth;
		this.trapBaseY = trapBaseY;
		this.trapHeight = trapHeight;
		this.numOfLines = this.trapHeight; // Each line is 1px tall so: the num of lines needed = trap height
		this.lineLength = this.trapBaseWidth; // Line length will vary but initial length is the base of the trap
		this.lineStartPosX = lineStartPosX;
		this.lineEndPosX = lineEndPosX;
	}

	public static void makeTrap(Graphics2D g2) {
		g2.setColor(Color.YELLOW);
		for (int i = 0; i < numOfLines; i++) {
			double slopeX = 1.0;
			double slopeY = (trapHeight/(lineEndPosX-lineStartPosX));
			double x1 = lineStartPosX + (slopeX * i);
			double x2 = trapBaseWidth - (slopeY * i);
			double y1 = trapBaseY - (slopeY * i);
			double y2 = y1; // Always a straight line

			lines.add(new Line2D.Double(x1, y1, x2, y2));
			g2.draw(lines.get(0));
			g2.fill(lines.get(0));
		}
	}
}
