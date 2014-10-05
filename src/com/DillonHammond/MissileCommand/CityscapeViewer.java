package com.DillonHammond.MissileCommand;

import javax.swing.JFrame;
import java.awt.Color;

/**
 * Created by Dillon on 10/1/14.
 */
public class CityscapeViewer {

	private static final int WIDTH = 1000;
	private static final int HEIGHT = 800;

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("Missile Command");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		CityscapeComponent component = new CityscapeComponent(WIDTH, HEIGHT);


		frame.add(component);



		frame.setVisible(true);

		frame.getContentPane().setBackground(Color.BLACK); // Sets background to black

/*
		while (true) {
			component.repaint();
		}*/
	}
}
