package com.techelevator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.techelevator.view.Menu.currentMoneyProvided;

public class PurchaseMenuApp extends JFrame{
    private JPanel contentPane;
    private JPanel app;
    private JLabel titleLabel;
    private JButton feedMoneyButton;
    private JButton selectProductButton;
    private JButton finishTransactionButton;
    private JTextArea textArea1;
    private JPanel feedMoney;
    private JTextArea textArea2;
    private JButton oneDollar;
    private JButton twoDollar;
    private JButton fiveDollar;
    private JButton tenDollar;
    private JButton twentyDollar;
    private JPanel selectProduct;
    private JButton A1;
    private JButton A2;
    private JButton A3;
    private JButton A4;
    private JButton B1;
    private JButton B2;
    private JButton B3;
    private JButton B4;
    private JButton C1;
    private JButton C2;
    private JButton C3;
    private JButton C4;
    private JButton D1;
    private JButton D2;
    private JButton D3;
    private JButton D4;
    private JButton returnToMainMenu;
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    CardLayout cardLayout;
    JButton[] buttons = {A1, A2, A3, A4, B1, B2, B3, B4, C1, C2, C3, C4, D1, D2, D3, D4};
    ProductSelection productSelection;

    public PurchaseMenuApp() {
        JFrame frame = new JFrame("Vendo-Matic 800");
        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        contentPane.add(app, "Purchase Menu");
        contentPane.add(feedMoney, "Feed Money");
        contentPane.add(selectProduct, "Select Product");
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        textArea1.setText("Current Money Provided: " + currency.format(currentMoneyProvided));

        finishTransactionButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int moneyInCents = (int) (currentMoneyProvided * 100);

                int numOfQuarters = moneyInCents / 25;
                moneyInCents = moneyInCents % 25;

                int numOfDimes = moneyInCents / 10;
                moneyInCents = moneyInCents % 10;

                int numOfNickles = moneyInCents / 5;

                textArea1.setText("Returning "+ numOfQuarters + " quarters, " + numOfDimes + " dimes, and " + numOfNickles + " nickles.");

                currentMoneyProvided = 0;
            }
        });

        feedMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Feed Money");
            }
        });

        oneDollar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentMoneyProvided += 1;
                cardLayout.show(contentPane, "Purchase Menu");
                textArea1.setText("Current Money Provided: " + currency.format(currentMoneyProvided));
            }
        });

        twoDollar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentMoneyProvided += 2;
                cardLayout.show(contentPane, "Purchase Menu");
                textArea1.setText("Current Money Provided: " + currency.format(currentMoneyProvided));
            }
        });

        fiveDollar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentMoneyProvided += 5;
                cardLayout.show(contentPane, "Purchase Menu");
                textArea1.setText("Current Money Provided: " + currency.format(currentMoneyProvided));
            }
        });

        tenDollar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentMoneyProvided += 10;
                cardLayout.show(contentPane, "Purchase Menu");
                textArea1.setText("Current Money Provided: " + currency.format(currentMoneyProvided));
            }
        });

        twentyDollar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentMoneyProvided += 20;
                cardLayout.show(contentPane, "Purchase Menu");
                textArea1.setText("Current Money Provided: " + currency.format(currentMoneyProvided));
            }
        });

        selectProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Select Product");

                for(int i = 0; i < buttons.length; i++) {
                    buttons[i].setText(String.valueOf(Inventory.INVENTORY_ARRAY[i]));
                }
            }
        });

        returnToMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App app = new App();
            }
        });

        A1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("A1");
            }
        });

        A2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("A2");
            }
        });

        A3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("A3");
            }
        });

        A4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("A4");
            }
        });

        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("B1");
            }
        });

        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("B2");
            }
        });

        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("B3");
            }
        });

        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("B4");
            }
        });

        C1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("C1");
            }
        });

        C2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("C2");
            }
        });

        C3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("C3");
            }
        });

        C4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("C4");
            }
        });

        D1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("D1");
            }
        });

        D2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("D2");
            }
        });

        D3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("D3");
            }
        });

        D4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productSelection = new ProductSelection(currentMoneyProvided);
                productSelection.selectProduct("D4");
            }
        });
    }

    public static void main(String[] args) {
       PurchaseMenuApp purchaseMenuApp = new PurchaseMenuApp();
    }

    public void writeText(String text) {
        textArea1.setText(text);
    }
}
