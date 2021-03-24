package com.example.limsa_automaatti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BottleDispenser dispenser = BottleDispenser.getInstance();
    private TextView balanceView;
    private TextView bottlesView;
    private TextView print;
    private TextView moneyWarning;
    private Button returnMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        balanceView = (TextView) findViewById(R.id.balanceView);
        bottlesView = (TextView) findViewById(R.id.bottlesView);
        print = (TextView) findViewById(R.id.ohje);
        moneyWarning = (TextView) findViewById(R.id.warning);
        returnMoney = (Button)findViewById(R.id.back);
        initializeDispenser();
        updateUIStatus();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUIStatus();
    }

    private void initializeDispenser(){

        Bottle temp1 = new Bottle("Pepsi Max", 0.5f, 1.8f);
        Bottle temp2 = new Bottle("Pepsi Max", 1.5f, 2.2f);
        Bottle temp3 = new Bottle("Coca-Cola Zero", 0.5f, 2.0f);
        Bottle temp4 = new Bottle("Coca-Cola Zero", 1.5f, 2.5f);
        Bottle temp5 = new Bottle("Fanta Zero", 0.5f, 1.95f);

        dispenser.addBottle(temp1);
        dispenser.addBottle(temp2);
        dispenser.addBottle(temp3);
        dispenser.addBottle(temp4);
        dispenser.addBottle(temp5);
    }

    private void updateUIStatus() {
        String bottles = dispenser.listBottles();
        bottlesView.setText("Bottles available:\n" + bottles);
        balanceView.setText(String.format("Balance: %.2f€", dispenser.getBalance()));
    }

    public void addMoneyButton(View view) {
        dispenser.addMoney();
        balanceView.setText(String.format("Balance: %.2f€", dispenser.getBalance()));
        updateUIStatus();
    }

    //pullon valinta toistaa kovasti itseään, mutta se oli helpoin tapa jonka keksin ilman spinneriä,
    //jotta käyttäjä kuitenkin voi valita minkä pullon haluaa
    //halutessaan koodia on silti helppo jalostaa pidemmälle

    public void buyBottle1(View view) {
        int choice = 1;
        int i;
        i = dispenser.buyBottle(choice);
        if (i == 1) {
            moneyWarning.setText(" ");
            String name = dispenser.printBought(choice);
            print.setText("You bought bottle number " + choice + ", " + name);
            updateUIStatus();
        } else if (i == 0) {
            moneyWarning.setText("Add money first!");
        }
    }

    public void buyBottle2(View view) {
        int choice = 2;
        int i;
        i = dispenser.buyBottle(choice);
        if (i == 1) {
            moneyWarning.setText(" ");
            String name = dispenser.printBought(choice);
            print.setText("You bought bottle number " + choice + ", " + name);
            updateUIStatus();
        } else if (i == 0) {
            moneyWarning.setText("Add money first!");
        }
    }

    public void buyBottle3(View view) {
        int choice = 3;
        int i;
        i = dispenser.buyBottle(choice);
        if (i == 1) {
            moneyWarning.setText(" ");
            String name = dispenser.printBought(choice);
            print.setText("You bought bottle number " + choice + ", " + name);
            updateUIStatus();
        } else if (i == 0) {
            moneyWarning.setText("Add money first!");
        }
    }

    public void buyBottle4(View view) {
        int choice = 4;
        int i;
        i = dispenser.buyBottle(choice);
        if (i == 1) {
            moneyWarning.setText(" ");
            String name = dispenser.printBought(choice);
            print.setText("You bought bottle number " + choice + ", " + name);
            updateUIStatus();
        } else if (i == 0) {
            moneyWarning.setText("Add money first!");
        }
    }

    public void buyBottle5(View view) {
        int choice = 5;
        int i;
        i = dispenser.buyBottle(choice);
        if (i == 1) {
            moneyWarning.setText(" ");
            String name = dispenser.printBought(choice);
            print.setText("You bought bottle number " + choice + ", " + name);
            updateUIStatus();
        } else if (i == 0) {
            moneyWarning.setText("Add money first!");
        }
    }

    public void returnMoneyToUser(View view) {
        returnMoney.setText(String.format("Returned: %.2f€", dispenser.getBalance()));
        dispenser.returnMoney();
        updateUIStatus();
    }
}


