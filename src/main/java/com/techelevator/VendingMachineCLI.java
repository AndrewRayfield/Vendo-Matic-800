package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenu;

import java.text.NumberFormat;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_SALES_REPORT = "";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_SALES_REPORT };
	/////////////////////////////////
	//Purchase Menu/////////////////
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_FEED_MONEY , PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION };
	///////////////Money option/////////////////
	private static final String FEED_MONEY_1 = "$1";
	private static final String FEED_MONEY_2 = "$2";
	private static final String FEED_MONEY_5 = "$5";
	private static final String FEED_MONEY_10 = "$10";

	private static final String FEED_MONEY_20 = "$20";
	private static final String [] FEED_MONEY_OPTIONS = {FEED_MONEY_1,FEED_MONEY_2,FEED_MONEY_5,FEED_MONEY_10,FEED_MONEY_20};

	/////////////////////////////


	private Menu menu;
	private PurchaseMenu purchaseMenu;
	private SalesReport salesReport = new SalesReport();

	public VendingMachineCLI(Menu menu , PurchaseMenu purchaseMenu) {
		this.menu = menu;
		this.purchaseMenu = purchaseMenu;
	}

	public void run() {
		//Might need to be in ProductSelection Class?
		Inventory.restock();
		salesReport.createReport();

		//Does this need to be in another class?
		double currentMoneyProvided = 0;

		while (true) {
			//Get choice using menu class
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items from Inventory class
				Inventory.displayInventory();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				//Used similarly to menu
				// do purchase
				while (true) {
					//formatting money
					NumberFormat currency = NumberFormat.getCurrencyInstance();
					System.out.println("Current Money Provided: " + currency.format(currentMoneyProvided));

					//Get choice using PurchaseMenu class
					//getChoiceFromOptions is taking from Menu Class
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					//Purchase option selection start
					//Feed Money Option
					if (purchaseChoice.equals(PURCHASE_MENU_FEED_MONEY)) {
						//Set to create a starting amount
						double moneyBefore = currentMoneyProvided;

						//Does this need to be taken from Menu class?
						String feedMoneyChoice = (String) menu.getChoiceFromOptions(FEED_MONEY_OPTIONS);

						/////Add money
						if (feedMoneyChoice.equals(FEED_MONEY_1)) {
							currentMoneyProvided += 1.0;
						} else if (feedMoneyChoice.equals(FEED_MONEY_2)) {
							currentMoneyProvided += 2.0;
						} else if (feedMoneyChoice.equals(FEED_MONEY_5)) {
							currentMoneyProvided += 5.0;
						} else if (feedMoneyChoice.equals(FEED_MONEY_10)) {
							currentMoneyProvided += 10.0;
						} else if (feedMoneyChoice.equals(FEED_MONEY_20)) {
							currentMoneyProvided += 20.0;
						}

						//Logs starting amount and end amount in Log.txt
						LogUpdate.log("Feed Money", moneyBefore, currentMoneyProvided);

					} else if (purchaseChoice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						//Will you please explain this one?
						Items itemsChoice = (Items) menu.getChoiceFromOptions(Inventory.INVENTORY_ARRAY);

						//Decides if product available or if there is enough money
						// Out of stock message should be during product selection
						if (itemsChoice.getStock() < 1) {
							System.out.println("Product Is Out Of Stock");
						} else if (currentMoneyProvided < itemsChoice.getPrice()) {
							System.out.println("Not Enough Money Provided");
						} else {
							double moneyBefore = currentMoneyProvided;

							System.out.println(itemsChoice.dispensingMessage());
							itemsChoice.sellProduct();
							salesReport.addToReport(itemsChoice.getName());
							currentMoneyProvided -= itemsChoice.getPrice();
							LogUpdate.log(itemsChoice.getName() + " " + itemsChoice.getLocation(), moneyBefore, currentMoneyProvided);
						}
					} else if (purchaseChoice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
						double moneyBefore = currentMoneyProvided;

						System.out.println(makeChange(currentMoneyProvided));
						currentMoneyProvided = 0.0;
						LogUpdate.log("give change", moneyBefore, currentMoneyProvided);
						break;
					}
					//Purchase Option Selection end
				}
			} else if (choice.equals(MAIN_MENU_OPTION_SALES_REPORT)){
				salesReport.runReport();
			} else {
				System.exit(0);
			}
		}
	}
	public static String makeChange (double moneyRemaining){
		int moneyInCents = (int) (moneyRemaining * 100);

		int numOfQuarters = moneyInCents / 25;
		moneyInCents = moneyInCents % 25;

		int numOfDimes = moneyInCents / 10;
		moneyInCents = moneyInCents % 10;

		int numOfNickles = moneyInCents / 5;

		return "Returning "+ numOfQuarters + " quarters, " + numOfDimes + " dimes, and " + numOfNickles + " nickles.";
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		PurchaseMenu purchaseMenu = new PurchaseMenu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu , purchaseMenu);
		cli.run();
	}
}


