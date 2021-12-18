package com.company;

import java.util.ArrayList;

public class MissingProducts {
    private ArrayList<String> products = new ArrayList<String>();

    public MissingProducts(ArrayList<String> products) {
        this.products = products;
    }
    public MissingProducts() {

    }

    public ArrayList<String> getProducts() {
        return products;
    }
    public void print(){
        System.out.println("Необходимые продукты:");
        for(String prod : products){
            System.out.print(prod+",");
        }
    }
    public void setProducts(ArrayList<String> products) {
        this.products = products;
    }
}
