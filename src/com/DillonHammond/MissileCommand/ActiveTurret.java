package com.DillonHammond.MissileCommand;

import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Point;

/**
 * Created by Dillon on 10/4/14.
 */
public class ActiveTurret {

	private static Color turretColor;
	private static double screenWidth;
	private static double screenHeight;
	private static double turretHeight;
	private static double turretWidth;
	private static Color laserOriginColor;
	public static ArrayList<Ellipse2D.Double> laserOrigins = new ArrayList<Ellipse2D.Double>();
	private static boolean turret0Active = false;
	private static boolean turret1Active = false;
	private static boolean turret2Active = false;
	private static Point mouseLocation;
	private static int y = -1;

	public ActiveTurret(Color turretColor, double screenWidth, double screenHeight) {
		// Get screen values
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		// Start turret creation
		this.turretColor = turretColor;
		this.turretHeight = ((this.screenHeight/6.0)/2.0); // The turret will be half of the base height (screenHeight/6.0)
		this.turretWidth = (this.screenWidth/9.0); // The turret will be as wide as the base
		// Start Laser Origin Creation
		this.laserOriginColor = new Color(255, 255, 255, 0); // Draws clear circles
	}

	public static void setLaserOrigins() {
		for (int i = 0; i < 9; i += 4) {
			laserOrigins.add(new Ellipse2D.Double((i*turretWidth) + 120.0/3.0, 550, 95.0/3.0, 95.0/3.0));
		}
	}

	public static boolean laserActivated(int turretNum) {
		boolean active = false;
		switch (turretNum) {
			case 0:
				if (!turret0Active) {
					active = false;
				} else if(turret0Active) {
					active = true;
				}
				break;
			case 1:
				if (!turret1Active) {
					active = false;
				} else if (turret1Active) {
					active = true;
				}
				break;
			case 2:
				if (!turret2Active) {
					active = false;
				} else if (turret2Active) {
					active = true;
				}
				break;
			default:
				active = false;
		}

		return active;
	}

	public static void switchLaserState(int turretNum) {
		switch (turretNum) {
			case 0:
				if (!turret0Active) {
					turret0Active = true;
				} else if (turret0Active) {
					turret0Active = false;
				}
				break;
			case 1:
				if (!turret1Active) {
					turret1Active = true;
				} else if (turret1Active) {
					turret1Active = false;
				}
				break;
			case 2:
				if (!turret2Active) {
					turret2Active = true;
				} else if (turret2Active) {
					turret2Active = false;
				}
				break;
			default:
		}
	}

	public static void activateTurret() {
		boolean laserActivate = false;
		mouseLocation = CityscapeViewer.mouseCoord;
		boolean clicked = CityscapeViewer.mouseClicked;
		double[] whereClicked = {0,0};
		try {
			if (y != 0 && mouseLocation.getX() < (screenWidth / 3.0)) {
				switchLaserState(0);
				laserActivate = laserActivated(1);
				y = 0;
				if (laserActivate) {
					switchLaserState(1);
				}
				laserActivate = laserActivated(2);
				if (laserActivate) {
					switchLaserState(2);
				}
			} else if (y != 1 && mouseLocation.getX() >= (screenWidth / 3.0) && mouseLocation.getX() < 2.0 * (screenWidth / 3.0)) {
				switchLaserState(1);
				laserActivate = laserActivated(0);
				y = 1;
				if (laserActivate) {
					switchLaserState(0);
				}
				laserActivate = laserActivated(2);
				if (laserActivate) {
					switchLaserState(2);
				}
			} else if (y != 2 && mouseLocation.getX() >= 2.0 * (screenWidth / 3.0)) {
				switchLaserState(2);
				laserActivate = laserActivated(0);
				y = 2;
				if (laserActivate) {
					switchLaserState(0);
				}
				laserActivate = laserActivated(1);
				if (laserActivate) {
					switchLaserState(1);
				}
			}
			if (clicked) {
				whereClicked[0] = mouseLocation.getX();
				whereClicked[1] = mouseLocation.getY();
				if (laserActivated(0)) {
				}
			}
		} catch (NullPointerException e) {
			// Ignores NullPointerException from mouse being outside the JFrame
			// Does not affect performance
		}
//		System.out.println(laserActivated(0) + " " + laserActivated(1) + " " + laserActivated(2));
	}

	public static void draw(Graphics2D g2) {
		double x = 0.0;
		for (int i = 0; i < 3; i++) {
			Trapezoid turret = new Trapezoid(turretColor, turretWidth, (5.0*(screenHeight/6.0))-50.0, turretHeight, (x*turretWidth));
			turret.makeTrap(g2);
			x += 4.0;
		}
		setLaserOrigins();
		g2.setColor(laserOriginColor);
		for (int i = 0; i < laserOrigins.size(); i++) {
			g2.draw(laserOrigins.get(i));
			g2.fill(laserOrigins.get(i));
		}
	}
}
