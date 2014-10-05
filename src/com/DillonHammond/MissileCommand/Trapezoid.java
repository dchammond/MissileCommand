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
	private static double trapHeight;
	private static double trapBaseWidth;
	private static double trapBaseY;
	private static double lineStartPosX;
	private static ArrayList<Line2D.Double> lines = new ArrayList<Line2D.Double>();

	public Trapezoid(Color lineColor, double trapBaseWidth, double trapBaseY, double trapHeight, double lineStartPosX) {
		this.lineColor = lineColor;
		this.trapBaseWidth = trapBaseWidth;
		this.trapBaseY = trapBaseY;
		this.trapHeight = trapHeight;
		this.numOfLines = this.trapHeight; // Each line is 1px tall so: the num of lines needed = trap height
		this.lineStartPosX = lineStartPosX;
	}

	public static void makeTrap(Graphics2D g2) {
		g2.setColor(lineColor);
		for (int i = 0; i < numOfLines; i++) {
			double x1 = lineStartPosX + ((i*(trapBaseWidth/3.0))/50.0);
			double x2 = trapBaseWidth - ((i*(trapBaseWidth/3.0))/50.0);
			double y1 = trapBaseY - (i);
			double y2 = y1; // Always a straight line

			lines.add(new Line2D.Double(x1, y1, x2, y2));
			g2.draw(lines.get(i));
			g2.fill(lines.get(i));
		}
	}
}
