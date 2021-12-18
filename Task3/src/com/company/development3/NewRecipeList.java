package com.company.development3;

import com.company.AvailableProducts;
import com.company.Recipe;
import com.company.RecipeList;
import com.company.resources.Const;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NewRecipeList extends RecipeList {

    protected ArrayList<NewRecipe> recipes = new ArrayList<NewRecipe>();

    public NewRecipeList() throws IOException {

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
        String[] appliances = null;

        int key = 0;

        while (scan.hasNextLine()) {
            if (key == 0) {
                newLine = scan.nextLine().split(",");
                name = newLine[0];
                type = newLine[1];
            } else if(key == 1) {
                ingredients = scan.nextLine().split(",");


            } else if(key == 2) {
                appliances = scan.nextLine().split(",");


            }
            else if (key == 3){
                RecipeList().add(new NewRecipe(name, type, ingredients, scan.nextLine(), appliances));
                key = -1;
            }
            key++;
        }
        reader_file.close();
    }

    public ArrayList<NewRecipe> newsearch(String type, AvailableProducts aproducts, String product) throws IOException {
        updateRecipeList();
        ArrayList<NewRecipe> answerList = new ArrayList<NewRecipe>();
        for(NewRecipe answer : recipes){
            if(answer.getType().equals(type)){
                for(String prod: answer.getIngredients()){
                    if(prod.equals(product)){
                        answerList.add(answer);
                    }
                }
            }
        }
        ArrayList<NewRecipe> new_answerList = new ArrayList<NewRecipe>();
        for(NewRecipe res: answerList){
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
}
