package com.eimacs.lab05;

import java.util.ArrayList;
import com.eimacs.lab05gui.Turtle;
import java.awt.Graphics;

/**
 *
 * @author |Your name|
 * @version 1.0 |Today's date|
 */
public class TurtleProgram {
	private ArrayList<Action> myActions = new ArrayList<Action>();
	private boolean isValid;

	public TurtleProgram() {
		setIsValid(false);
	}

	public void addAction(Action a) {
		setIsValid(false);
		myActions.add(a);
	}

	public void setIsValid(boolean b) {
		isValid = b;
	}

	public String toString() {
		String ret = "";
		for (int i = 0; i < myActions.size(); i++) {
			ret = ret + myActions.get(i);
			if (i != myActions.size() - 1)
				ret += "\n";
		}
		return ret;
	}

	public void execute(Turtle t, Graphics g) {
		if (!isValid)
			return;
		for (Action a : myActions) {
			a.execute(t, g);
		}
	}
}