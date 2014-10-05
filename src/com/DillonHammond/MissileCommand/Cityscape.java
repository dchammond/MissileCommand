package com.DillonHammond.MissileCommand;

import java.awt.Graphics2D;
import java.awt.Color;

public class Cityscape {

	private static int width;
	private static int height;
	private static Color passiveBaseColor;
	private static PassiveBase passiveBases;
	private static Color cityColor;
	private static PassiveCity passiveCities;

	public Cityscape(int width, int height) {
		this.width = width;
		this.height = height;
		this.passiveBaseColor = new Color(26, 11, 240);
		this.cityColor = new Color(24, 255, 0);
		this.passiveBases = new PassiveBase(this.passiveBaseColor, this.width, this.height);
		this.passiveCities = new PassiveCity(this.cityColor, this.width, this.height);

	}

	public void draw(Graphics2D g2) {
		passiveBases.draw(g2);
		passiveCities.draw(g2);
	}

}
