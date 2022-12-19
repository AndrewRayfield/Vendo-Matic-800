package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenu;

import java.text.NumberFormat;
import java.util.Map;

public class VendingMachineCLI {
	private Menu menu;
	private SalesReport salesReport = new SalesReport();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		Inventory.restock();
		salesReport.createReport();
		menu.showMenu();
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}


