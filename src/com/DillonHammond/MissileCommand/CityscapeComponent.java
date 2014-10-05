package com.DillonHammond.MissileCommand;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Created by Dillon on 10/1/14.
 */
public class CityscapeComponent extends JComponent{

	private static int width;
	private static int height;

	public CityscapeComponent(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		Cityscape cityscape = new Cityscape(width, height);

		cityscape.draw(g2);
	}
}
