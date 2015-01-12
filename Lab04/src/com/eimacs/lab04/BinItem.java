package com.eimacs.lab04;

import java.util.ArrayList;

public class BinItem {
	String mySKU;
	int myQuantity;

	public BinItem(String sku, int quantity) {
		mySKU = sku;
		myQuantity = quantity;
	}

	public String getSKU() {
		return mySKU;
	}

	public int getQuantity() {
		return myQuantity;
	}

	public String toString() {
		return "SKU " + getSKU() + ": " + getQuantity();
	}
}
