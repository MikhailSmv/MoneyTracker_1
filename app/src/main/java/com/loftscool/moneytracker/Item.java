package com.loftscool.moneytracker;

public class Item {


    public static final String TYPE_EXPENSE = "expense";
    public static final String TYPE_INCOME = "income";
    public static final String TYPE_UNKNOWN = "unknown";
    public String name;
    public int price;
    public String type;
    public int id;
    public Item(String name, int price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }


}
