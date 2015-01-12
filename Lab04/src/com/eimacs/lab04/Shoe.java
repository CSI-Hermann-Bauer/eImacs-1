package com.eimacs.lab04;

/**
 *
 * @author Andrew Katz
 * @version 1.0 1-7-2015
 */
// Define the Shoe class here
public class Shoe extends Footwear {
	public Shoe(String a, double b, String c) {
		super(a, b, c);
	}

	public String getType() {
		return "Shoe";
	}
}