package com.techelevator.view;

import com.techelevator.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;

public class Menu {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_SALES_REPORT = "Sales Report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_SALES_REPORT };
	static double currentMoneyProvided = 0;
	private PrintWriter out;
	private Scanner in;

	SalesReport salesReport = new SalesReport();

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);

	}

	//public Object getChoiceFromOptions(Object[] options) {
	public Object getChoiceFromOptions(Object[] options, boolean isMainMenu) {
		Object choice = null;
		while (choice == null) {
			if (isMainMenu) {
				displayMenuOptions(options);
			} else {
				displayProductOptions(options);
			}
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			// AE: Compares userInput to the options from inventory
			// Likely will cause issues due to overlap (A'1', B'1', 'A'1, 'A'2)
			for(Object objects : options){
				if(objects.toString().contains(userInput)){
					choice = objects;
					break;
				}
			}
			//
			// Reference for user input, determines if they're typing 1
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}



		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}
	private void displayProductOptions(Object[] options) {
		//Enumerates the list of products to choose from
		// appends the option listing ("A1", "B2", etc.) instead of the 1-14
		out.println();
		for (int i = 0; i < options.length; i++) {
			//int optionNum = i + 1;
			out.println(options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	public void showMenu() {
		while (true) {
			//Get choice using menu class
			String choice = (String) getChoiceFromOptions(MAIN_MENU_OPTIONS, true);

			PurchaseMenu purchaseMenu = new PurchaseMenu(System.in, System.out);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items from Inventory class
				Inventory.displayInventory();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchaseMenu.showPurchaseMenu();
			} else if (choice.equals(MAIN_MENU_OPTION_SALES_REPORT)){
				salesReport.displayReport();
			} else {
				System.exit(0);
			}
		}
	}

}
