package com.DillonHammond.MissileCommand;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.SwingUtilities;
import java.awt.MouseInfo;

/**
 * Created by Dillon on 10/1/14.
 */
public class CityscapeViewer {

	private static final int WIDTH = 1000;
	private static final int HEIGHT = 800;
	private static CityscapeComponent component;
	public static java.awt.Point xy;

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame();

		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Missile Command");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		component = new CityscapeComponent(WIDTH, HEIGHT);


		frame.add(component);



		frame.setVisible(true);

		frame.getContentPane().setBackground(Color.BLACK); // Sets background to black


		while (true) {
			component.repaint();
			Thread.sleep(17); // Approximately 60fps
			mouseLocation();
			setTurretActive();
		}
	}


	public static java.awt.PointerInfo mouseLocation() {
		return MouseInfo.getPointerInfo();
	}

	public static void setTurretActive() {
		java.awt.PointerInfo mouseLocation = mouseLocation();
		xy = mouseLocation.getLocation();
		SwingUtilities.convertPointFromScreen(xy, component);
	}

}
