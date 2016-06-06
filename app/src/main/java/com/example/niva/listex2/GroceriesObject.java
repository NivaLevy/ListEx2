package com.example.niva.listex2;

/**
 * Created by Niva on 05/06/2016.
 */
public class GroceriesObject {
    private String title;
    private int img, amount;

    public GroceriesObject(String title, int amount, int img) {
        this.title = title;
        this.amount = amount;
        this.img = img;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public int getImg() {
        return img;
    }

    public int getAmount() {
        return amount;
    }
}
