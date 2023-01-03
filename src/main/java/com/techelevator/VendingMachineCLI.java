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
		salesReport.createReport();
		menu.showMenu();
	}
	public static void main(String[] args) {
		App app = new App();
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}