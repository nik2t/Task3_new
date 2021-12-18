package com.company.development3;

import com.company.Assistant;
import com.company.Recipe;
import com.company.RecipeList;
import com.company.User;

import java.io.IOException;
import java.util.ArrayList;

public class ThirdAssistent extends Assistant {

    protected ArrayList<NewRecipe> newanswer;
    protected NewRecipeList newRecipeList;
    protected Appliances appliances;

    public ThirdAssistent(RecipeList recipeList, User user, NewRecipeList newRecipeList, Appliances appliances) {
        super(recipeList, user);
        this.newRecipeList = newRecipeList;
        this.appliances = appliances;
    }

    public ArrayList<NewRecipe> new_pick_up(String type, String product) throws IOException {
        newanswer = newRecipeList.newsearch(type, user.getAvail_products(), product);
        for(int i = 0; i < appliances.getAppliances().length; i++) {
            newanswer = inspection(appliances.getAppliances()[i]);
        }
        return newanswer;
    }


    private ArrayList<NewRecipe> inspection(String appliance){
        ArrayList<NewRecipe> answer_new = new ArrayList<NewRecipe>();

        for (NewRecipe ans : newanswer) {
            int counter = 0;
            for (String appl : ans.getAppliances()) {

                if (appl.equals(appliance)) {
                    counter++;
                }
            }
            if(counter == 0){
                answer_new.add(ans);
                System.out.println(counter);
                ans.print();
            }
        }

        return answer_new;
    }

}
