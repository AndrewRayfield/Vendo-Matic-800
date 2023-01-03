package com.techelevator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class App extends JFrame{
    private JButton displayInventoryButton;
    private JPanel app;
    private JLabel titleLabel;
    private JTextArea textArea1;
    private JButton purchaseButton;
    private JButton exitButton;
    PurchaseMenuApp purchaseMenuApp;

    public App() {
        JFrame frame = new JFrame("Vendo-Matic 800");
        frame.setContentPane(app);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        displayInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inventory = "";
                for (Items items : Inventory.INVENTORY_ARRAY) {
                    inventory += items + "\n" + "\n";
                    textArea1.setText(inventory);
                }

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                purchaseMenuApp = new PurchaseMenuApp();
                frame.hide();
            }
        });
    }
}
