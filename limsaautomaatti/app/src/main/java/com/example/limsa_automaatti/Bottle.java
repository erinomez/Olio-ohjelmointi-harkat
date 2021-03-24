package com.example.limsa_automaatti;

public class Bottle {
    private String name;
    private float size;
    private float price;

    public Bottle(String n, float s, float p){
        name = n;
        size = s;
        price = p;
    }

    public String getName(){
        return name;
    }
    public float getSize(){
        return size;
    }
    public float getPrice(){
        return price;
    }
}

