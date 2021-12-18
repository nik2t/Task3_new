package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Conductor {

    protected RecipeList recipeList;
    protected    User user;


    public Conductor(RecipeList recipeList, User user) {
        this.recipeList = recipeList;
        this.user = user;

    }
    public ArrayList<String> check(Recipe recipe) {

        ArrayList<String> result = new ArrayList<String>();
        String product = "";
        for(String prod: recipe.getIngredients()) {
            int counter = 0;
                for (String product_user : user.getAvail_products().getProducts()){
                    if (prod.equals(product_user)) {
                        counter++;
                    }
                }
            if(counter != 1){
                product = prod;

            }
        }
        result.add(product);
        return result;
    }

    public void demonstration(){
        ArrayList<String> missing = new ArrayList<String>();
        int counter = 0;
        for(Recipe res: recipeList.getRecipes()){
            counter++;
            System.out.println("Рецепт №"+ counter);
            res.print();
            missing = check(res);
            for(String miss: missing){
                System.out.println("------------------------\n");
                System.out.println(miss);
            }
        }
        System.out.println("Выберите рецепт(укажите №):");
        Scanner scanner = new Scanner(System.in);
        counter = scanner.nextInt();
        counter--;
        user.setLast_recipe(recipeList.getRecipes().get(counter));
        missing = check(user.getLast_recipe());
        user.setMiss_products(new MissingProducts(missing));

    }

    public RecipeList getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(RecipeList recipeList) {
        this.recipeList = recipeList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
