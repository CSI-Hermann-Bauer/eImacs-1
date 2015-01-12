package com.eimacs.lab04;

/**
 *
 * @author Andrew Katz
 * @version 1.0 1-7-2015
 */
public class Footwear {
	String myStyle, mySKU;
	double mySize;

	public Footwear(String style, double size, String sku) {
		myStyle = style;
		mySKU = sku;
		mySize = size;
	}

	public String getStyle() {
		return myStyle;
	}

	public double getSize() {
		return mySize;
	}

	public String getSKU() {
		return mySKU;
	}

	public String getType() {
		return "Unspecified";
	}

	public String printSize() {
		if (mySize - (int) mySize == 0)
			return "" + (int) mySize;
		return (int) mySize + "\u00bd";
	}

	public String toString() {
		String type = getType();
		String stem = "";
		if (!"Unspecified".equals(type))
			stem = type + " - ";
		return stem + getStyle() + " (size " + printSize() + ")";
	}

}
