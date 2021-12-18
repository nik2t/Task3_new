package com.company;

import com.company.resources.Const;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AvailableProducts {
    private String[] products;

    public AvailableProducts(String[] products) {
        this.products = products;
    }
    public AvailableProducts() throws IOException {
        updateAvailableProducts();
    }

    private void updateAvailableProducts() throws IOException {
        File file = new File(Const.FILE_AVAILABLE_PRODUCTS);
        FileReader reader_file = new FileReader(file);
        Scanner scan = new Scanner(reader_file);
        String[] newLine;

        while (scan.hasNextLine()) {
            products = scan.nextLine().split(",");
        }
        reader_file.close();
    }
    public String[] getProducts() {
        return products;
    }

    public void print(){
            System.out.println("Имеющиеся продукты:");
            for(String prod : products){
                System.out.print(prod+",");
            }

    }
    public void setProducts(String[] products) {
        this.products = products;
    }
}
