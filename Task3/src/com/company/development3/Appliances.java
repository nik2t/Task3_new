package com.company.development3;

import com.company.resources.Const;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Appliances {
    private String[] appliances;

    public Appliances(String[] appliances) {
        this.appliances = appliances;
    }
    public Appliances() throws IOException {
        updateAppliances();
    }

    private void updateAppliances() throws IOException {
        File file = new File(Const.FILE_AVAILABLE_PRODUCTS);
        FileReader reader_file = new FileReader(file);
        Scanner scan = new Scanner(reader_file);
        String[] newLine;

        while (scan.hasNextLine()) {
            appliances = scan.nextLine().split(",");
        }
        reader_file.close();
    }
    public String[] getAppliances() {
        return appliances;
    }

    public void print(){
        System.out.println("Имеющиеся риборы:");
        for(String prod : appliances){
            System.out.print(prod+",");
        }

    }
    public void setAppliances(String[] appliances) {
        this.appliances = appliances;
    }
}
