package com.eimacs.lab04;

/**
 *
 * @author Andrew Katz
 * @version 1.0 1-7-2015
 */
// Define the DressShoe class here
public class DressShoe extends Shoe {
	public DressShoe(String a, double b, String c) {
		super(a, b, c);
	}

	public String getType() {
		return "Dress Shoe";
	}
}