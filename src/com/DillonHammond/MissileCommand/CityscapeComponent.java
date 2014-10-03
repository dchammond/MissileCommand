package com.DillonHammond.MissileCommand;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;

/**
 * Created by Dillon on 10/1/14.
 */
public class CityscapeComponent extends JComponent{

	private static int numOfBases;
	private static Color groundColor;
	private static int[] color = {255,0,0};
	private static int width;
	private static int height;

	public CityscapeComponent(int width, int height) {
		this.numOfBases = 6;
		this.groundColor = new Color(this.color[0], this.color[1], this.color[2]);
		this.width = width;
		this.height = height;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		Cityscape cityscape = new Cityscape(width, height, numOfBases, groundColor);

		cityscape.draw(g2);
	}
}
