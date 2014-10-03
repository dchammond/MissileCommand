package com.DillonHammond.MissileCommand;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Color;

public class Cityscape {

	private int numOfBases;
	private Color groundColor;
	private static int width;
	private static int height;

	public Cityscape(int width, int height, int numOfBases, Color groundColor) {
		this.numOfBases = numOfBases;
		this.groundColor = groundColor;
		this.width = width;
		this.height = height;
	}

	public void draw(Graphics2D g2) {

	}

}
