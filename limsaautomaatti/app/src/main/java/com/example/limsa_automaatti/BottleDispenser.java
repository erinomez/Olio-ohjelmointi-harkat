package com.example.limsa_automaatti;

import java.util.ArrayList;

public class BottleDispenser {
    public int bottles;
    public float money;
    public ArrayList<Bottle> array = new ArrayList<Bottle>();
    public float price;
    public double money_back;

    private static BottleDispenser BD = new BottleDispenser();

    public void addBottle(Bottle bottle) {
        array.add(bottle);
    }

    public static BottleDispenser getInstance() {
        return BD;
    }

    public String listBottles() {
        Integer number;
        Bottle bottle;
        String list = "";
        for (Integer index = 0; index < array.size(); index++) {
            number = index + 1;
            bottle = array.get(index);
            list +=
                    number.toString() + ". Name: " + bottle.getName() + "\n	Size: "
                            + bottle.getSize() + "	Price: " + bottle.getPrice() + "\n" + "\n";
        }
        return list;
    }

    public String printBought(int choice) {
        if (choice == 1) {
            choice = choice - 1; // muuten indeksi menee nollaa pienemmäksi
        } else {
            choice = choice - 2;
        }
        String name = "";
        name = array.get(choice).getName();
        return name;
    }

    public float addMoney() {
        money += 1;
        return money;
    }

    public float getBalance() {
        return money;
    }

    public int buyBottle(int choice2) {
        choice2 = choice2 - 1;
        price = array.get(choice2).getPrice();
        if (money >= price) {
            money_back = money - price;
            money = money - price;
            bottles -= 1;
            int index = choice2;
            array.remove(index);
            int i = 1;
            return i;
        }
        else {
            int i = 0;
            return i;
        }
    }

    public float returnMoney() {
        money = 0;
        return money;
    }
}

/*
    public void printBottles() {
        System.out.println("Bottles available\n");
        for(int i = 0 ; i < array.size() ; i++) {
            System.out.println((i+1) + ". Name: " + array.get(i).getName() + "\n\t" +
                    "Size: " + array.get(i).getSize() + "\t" +
                    "Price: " + array.get(i).getPrice());
        }
    }

     */



