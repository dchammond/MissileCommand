package com.DillonHammond.MissileCommand;

import javax.swing.JFrame;

/**
 * Created by Dillon on 10/1/14.
 */
public class CityscapeViewer {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Missile Command");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CityscapeComponent component = new CityscapeComponent(WIDTH, HEIGHT);

		frame.add(component);

		frame.setVisible(true);

		while (true) {
			component.repaint();
		}
	}
}
