package com.eimacs.lab04;

import java.util.ArrayList;

public class Warehouse {
	private int myBinMax;
	private ArrayList<Footwear> myCatalog;
	private ArrayList<Bin> myBins;

	public Warehouse(int binMax) {
		myBinMax = binMax;
		myCatalog = new ArrayList<Footwear>();
		myBins = new ArrayList<Bin>(5);
		for (int i = 0; i < 5; i++)
			addBin();
	}

	public void addBin() {
		myBins.add(new Bin("B" + myBins.size()));
	}

	public String toString() {
		String s = "";
		for (Bin bin : myBins) {
			if (s.length() > 0)
				s += "\n";
			s += "Bin " + bin.getName() + ":";
			for (BinItem item : bin.getContents()) {
				s += "\n"
						+ Lab04Runner.lookupFootwear(myCatalog, item.getSKU())
						+ ", " + item;
			}
		}
		return s;
	}

	public void receive(Footwear f, int num) {
		boolean addToCat = true;
		for (Bin bin : myBins) {
			for (BinItem item : bin.getContents()) {
				if (Lab04Runner.lookupFootwear(myCatalog, item.getSKU())
						.equals(f.getSKU())) {
					addToCat = false;
				}
			}
		}
		if (addToCat) {
			myCatalog.add(f);
		}
		while (num != 0) {
			for (Bin bin : myBins) {
				while (bin.totalQuantity() < myBinMax && num != 0) {
					bin.add(new BinItem(f.getSKU(), 1));
					num--;
				}
			}
			if(num != 0) addBin();
		}
	}
}