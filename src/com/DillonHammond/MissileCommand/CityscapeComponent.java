package com.DillonHammond.MissileCommand;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

/**
 * Created by Dillon on 10/1/14.
 */
public class CityscapeComponent extends JComponent implements MouseListener{

	private static int width;
	private static int height;
	public static boolean mouseClicked = false;

	public CityscapeComponent(int width, int height) {
		this.width = width;
		this.height = height;
		CityscapeViewer.frame.addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		Cityscape cityscape = new Cityscape(width, height);

		cityscape.draw(g2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("here");
		mouseClicked = true;
		CityscapeViewer.setTurretActive();
		mouseClicked = false;
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
