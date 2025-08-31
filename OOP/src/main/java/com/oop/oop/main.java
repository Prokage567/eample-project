package com.oop.oop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws Exception {
        ArrayList<Product> products = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        products.add(new Product("cola", 30, 15));
        products.add(new Product("lemon", 20, 1));
        products.add(new Product("coke", 30, 10));
        products.add(new Product("jello", 15, 2));
        products.add(new Product("rc", 25, 25));
        money m = new money();
        int opt = 0, quantity = 0, opt2 = 0, product, thousands, five_hundreds, two_hundreds, hundreds, fifties,
                twenties, tens, fives, ones;
        String name = "";
        double price = 0, balance = 0, money = 0;
        do {
            System.out.print(
                    "=========Main Menu========= \n[1] Manage Products \n[2] Vending machine \n[0] Exit \nEnter an option: ");
            opt2 = Integer.parseInt(br.readLine());
            switch (opt2) {
                case 1:
                    do {
                        System.out.print(
                                "\n=========Menu========= \n[1] Products \n[2] Add new Product \n[3] Edit a Product \n[4] Delete a Product \n[0] Exit");
                        System.out.print("\nPlease enter an option: ");
                        opt = Integer.parseInt(br.readLine());
                        if (opt >= 5) {
                            System.out.print("\nYou have entered a wrong number! \nplease try again!");
                        } else {
                            switch (opt) {
                                case 1:
                                    listOfAllProducts(products);
                                    break;
                                case 2:
                                    System.out.print("Name of the Product: ");
                                    name = br.readLine();
                                    System.out.print("Price of the Product: ");
                                    price = Double.parseDouble(br.readLine());
                                    System.out.print("Quantity of the Product: ");
                                    quantity = Integer.parseInt(br.readLine());
                                    products.add(new Product(name, price, quantity));
                                    listOfAllProducts(products);
                                    System.out.print("\nThe product: [" + name + "] has been added to the menu\n");
                                    break;
                                case 3:
                                    listOfAllProducts(products);
                                    System.out.print("\nEnter what product to be edited: ");
                                    int Edit = Integer.parseInt(br.readLine());
                                    System.out.print("Update product's name: ");
                                    name = br.readLine();
                                    System.out.print("Update product's price: ");
                                    price = Double.parseDouble(br.readLine());
                                    System.out.print("Update product's quantity: ");
                                    quantity = Integer.parseInt(br.readLine());
                                    products.set(Edit - 1, new Product(name, price, quantity));
                                    String newName = products.get(Edit - 1).GetName();
                                    listOfAllProducts(products);
                                    System.out.print("\nThe product: [" + Edit + "] " + newName
                                            + " has been updated from the menu\n");
                                    break;
                                case 4:
                                    listOfAllProducts(products);
                                    System.out.print("\nProduct's number to be remove: ");
                                    int Delete = Integer.parseInt(br.readLine());
                                    String DelName = products.get(Delete - 1).GetName();
                                    products.remove(Delete - 1);
                                    listOfAllProducts(products);
                                    System.out.print("\nThe product: [" + Delete + "] " + DelName
                                            + " has been deleted from the menu\n");
                                    break;
                            }
                        }
                    } while (opt != 0);
                    break;
                case 2:
                    listOfAllProducts(products);

                    System.out.print("Enter a product: ");
                    product = Integer.parseInt(br.readLine());
                    if (product == 0) {
                        break;
                    }
                    String name2 = products.get(product - 1).GetName();
                    double price2 = products.get(product - 1).GetPrice();
                    int quantity2 = products.get(product - 1).GetQuantity();

                    if (quantity2 == 0) {
                        System.out.print("\n================================ \nthe product " + name2
                                + " is unavailable \n================================\n\n");
                        products.remove(product - 1);
                        break;
                    }

                    System.out.print("You chosed [ " + name2 + " ] that costs: " + price2 + "\n");
                    System.out.print("Insert Money (Balance: " + balance + "): ");
                    balance = Double.parseDouble(br.readLine());
                    m.SetBalance(balance);

                    while (balance < price2) {
                        System.out.print("\n================================================= \nYou have entered below the product's \namount and therefore, you will need to add more balance\n=================================================\n\n");
                        System.out.print("[ " + name2 + " ] price: " + price2+ "\n");
                        System.out.print("Insert Money (Balance: " + balance + "): ");
                        double balance1 = Double.parseDouble(br.readLine());
                        balance += balance1;
                        m.SetBalance(balance);
                    }

                    money = m.GetBalance() - price2;
                    products.set(product - 1, new Product(name2, price2, quantity2 - 1));
                    System.out.print("\nBalance: " + balance);
                    System.out.print("\nYou have bought [ " + name2 + " ] \ncost: " + price2);
                    System.out.printf("\nTotal Money left: %.2f", money);

                    if (money >= 1000) {
                        thousands = (int) Math.floor(money / 1000);
                        money %= 1000;
                        System.out.print("\n1000 peso bill - " + thousands);
                    }
                    if (money >= 500) {
                        five_hundreds = (int) Math.floor(money / 500);
                        money %= 500;
                        System.out.print("\n500 peso bill - " + five_hundreds);
                    }
                    if (money >= 200) {
                        two_hundreds = (int) Math.floor(money / 200);
                        money %= 200;
                        System.out.print("\n200 peso bill - " + two_hundreds);
                    }
                    if (money >= 100) {
                        hundreds = (int) Math.floor(money / 100);
                        money %= 100;
                        System.out.print("\n100 peso bill - " + hundreds);
                    }
                    if (money >= 50) {
                        fifties = (int) Math.floor(money / 50);
                        money %= 50;
                        System.out.print("\n50 peso bill - " + fifties);
                    }
                    if (money >= 20) {
                        twenties = (int) Math.floor(money / 20);
                        money %= 20;
                        System.out.print("\n20 peso bill - " + twenties);
                    }
                    if (money >= 10) {
                        tens = (int) Math.floor(money / 10);
                        money %= 10;
                        System.out.print("\n10 peso coin - " + tens);
                    }
                    if (money >= 5) {
                        fives = (int) Math.floor(money / 5);
                        money %= 5;
                        System.out.print("\n5 peso coin - " + fives);
                    }
                    if (money >= 1) {
                        ones = (int) Math.floor(money / 1);
                        money %= 1;
                        System.out.print("\n1 peso coin - " + ones);
                    }
                    if (money > 0) {
                        int centavos = (int) Math.round(money / 0.25);
                        System.out.print("\n25 centavos - " + centavos);
                    }

                    System.out.print("\n\n");
                    break;
            }
        } while (opt2 != 0);

    }

    public static void listOfAllProducts(ArrayList<Product> products) {
        int c = 1;
        System.out.print("\n===============Products==============\n");
        for (Product p : products) {
            System.out.printf("[%s] - %s %s Pesos (Quantity: %s) \n", c++, p.GetName(), p.GetPrice(), p.GetQuantity());
        }
        System.out.print("[0] Exit\n");
    }
}
