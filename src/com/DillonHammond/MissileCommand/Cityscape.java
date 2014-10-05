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
	private static ActiveTurret turret;
	private static Road road;

	public Cityscape(int width, int height) {
		this.width = width;
		this.height = height;
		this.passiveBaseColor = new Color(255, 250, 10);
		this.cityColor = new Color(24, 255, 0);
		this.passiveBases = new PassiveBase(this.passiveBaseColor, this.width, this.height);
		this.passiveCities = new PassiveCity(this.cityColor, this.width, this.height);
		this.turret = new ActiveTurret(Color.ORANGE, this.width, this.height);
		this.road = new Road(this.width, this.height);
	}

	public void draw(Graphics2D g2) {
		passiveBases.draw(g2);
		passiveCities.draw(g2);
		turret.draw(g2);
		road.draw(g2);
	}

}
