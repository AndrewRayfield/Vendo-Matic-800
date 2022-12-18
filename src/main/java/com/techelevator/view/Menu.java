package com.techelevator.view;

import com.techelevator.Inventory;
import com.techelevator.Items;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

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
}
