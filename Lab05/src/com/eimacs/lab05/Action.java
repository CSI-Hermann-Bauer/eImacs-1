package com.eimacs.lab05;

/**
 *
 * @author IMACS Curriculum Development Group
 * @version 1.0 March 11, 2014
 */

import com.eimacs.lab05gui.Turtle;
import java.awt.Graphics;

/**
 * @author |Your name|
 * @version 1.1 |Today's date|
 */
public abstract class Action {
	public Action() {
	}

	public abstract void execute(Turtle t, Graphics g);
}