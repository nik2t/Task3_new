package com.company.development2;

import com.company.AvailableProducts;
import com.company.MissingProducts;
import com.company.Recipe;
import com.company.User;

import java.util.Scanner;

public class AdvancedUser extends User {
    int number_of_servings;

    public AdvancedUser(AvailableProducts avail_products, MissingProducts miss_products) {
        super(avail_products, miss_products);
    }

    public void setLast_recipe(Recipe last_recipe) {

        this.last_recipe = last_recipe;
        System.out.println("Сколько порций готовим?");
        Scanner scanner = new Scanner(System.in);
        number_of_servings = scanner.nextInt();
    }

    public void print(){
        last_recipe.print();
        System.out.println("----------------");
        for(String miss: miss_products.getProducts()){
            System.out.println(miss +",");
        }
        if(last_recipe.getName() != null) {
            System.out.println("Количество порций:" + number_of_servings);
        }
    }

    public void delLast_recipe() {
        this.last_recipe = new Recipe();
        miss_products.getProducts().clear();
        number_of_servings = 0;
    }


}
