package com.eimacs.lab04;

import java.util.ArrayList;

public class Bin {
	private String myName;
	private ArrayList<BinItem> myContents;

	public Bin(String name) {
		myName = name;
		myContents = new ArrayList<BinItem>();
	}

	public String toString() {
		String ret = "Bin " + myName + ":";
		for (BinItem b : myContents) {
			ret += "\n" + b;
		}
		return ret;
	}

	public void remove(int i) {
		myContents.remove(i);
	}

	public int totalQuantity() {
		int total = 0;
		for (BinItem b : myContents)
			total += b.getQuantity();

		return total;
	}

	public void add(BinItem b) {
		String sku = b.getSKU();
		int n = b.getQuantity();
		BinItem item;
		for (int i = 0; i < myContents.size(); i++) {
			item = myContents.get(i);
			if (sku.equals(item.getSKU())) {
				int m = item.getQuantity();
				myContents.remove(i);
				myContents.add(new BinItem(sku, m + n));
				return;
			}
		}

		myContents.add(b);
	}

	public String getName() {
		return myName;
	}

	public ArrayList<BinItem> getContents() {
		return myContents;
	}
}
