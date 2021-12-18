package com.company;

import com.company.resources.Const;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class RecipeList {

    protected ArrayList<Recipe> recipes = new ArrayList<Recipe>();


    public RecipeList() throws IOException {
        updateRecipeList();
    }
    public ArrayList<Recipe> search(String type, AvailableProducts aproducts, String product) throws IOException {
            updateRecipeList();
            ArrayList<Recipe> answerList = new ArrayList<Recipe>();
            for(Recipe answer : recipes){
                if(answer.getType().equals(type)){
                    for(String prod: answer.getIngredients()){
                        if(prod.equals(product)){
                            answerList.add(answer);
                        }
                    }
                }
            }
        ArrayList<Recipe> new_answerList = new ArrayList<Recipe>();
            for(Recipe res: answerList){
                int counter = 0;
                for(String prod: res.getIngredients()) {

                    for (String product_user : aproducts.getProducts()){
                        if (prod.equals(product_user)) {
                            counter++;
                        }
                    }


                }
                if(counter == res.getIngredients().length){
                    new_answerList.add(res);
                }
            }

            return new_answerList;
    }
    private void updateRecipeList() throws IOException {
        recipes.clear();
        File file = new File(Const.FILE_RECIPE_LIST);
        FileReader reader_file = new FileReader(file);
        Scanner scan = new Scanner(reader_file);
        String[] newLine;
        String name = null;
        String type = null;
        String[] ingredients = null;
        int newLineLength;
        int key = 0;

        while (scan.hasNextLine()) {
            if (key == 0) {
                newLine = scan.nextLine().split(",");
                name = newLine[0];
                type = newLine[1];
            } else if(key == 1) {
                ingredients = scan.nextLine().split(",");


            }
            else if (key == 2){
                RecipeList().add(new Recipe(name, type, ingredients, scan.nextLine()));
                key = -1;
            }
            key++;
        }
        reader_file.close();
    }
    public void  print(){
        int counter = 0;
        for(Recipe res : recipes){
                counter++;
                System.out.println("Рецепт №" + counter);
                res.print();
        }
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public ArrayList<Recipe> RecipeList() {
        return this.recipes;
    }
}
