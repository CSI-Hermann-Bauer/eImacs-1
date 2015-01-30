package com.eimacs.lab05gui;

import com.eimacs.lab05.APPoint;
import java.awt.Graphics;

public class Turtle {
	private APPoint myPosition;
	private double myHeading;

	Turtle() {
		myPosition = new APPoint(0, 0);
		myHeading = 0;
	}

	public APPoint getPosition() {
		return myPosition;
	}

	public double getHeading() {
		return myHeading;
	}

	public void setHeading(double heading) {
		myHeading = heading;
	}

	public void lineTo(APPoint newPoint, Graphics g) {
		g.drawLine((int) myPosition.getX(), (int) myPosition.getY(),
				(int) newPoint.getX(), (int) newPoint.getY());
		myPosition = newPoint;
	}
}