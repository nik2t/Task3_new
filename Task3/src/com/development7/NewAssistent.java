package com.development7;

import com.company.Assistant;
import com.company.Recipe;
import com.company.RecipeList;
import com.company.User;

import java.io.IOException;
import java.util.ArrayList;

public class NewAssistent extends Assistant {

    ArrayList<String> allergy;

    public NewAssistent(RecipeList recipeList, User user, ArrayList<String> allergy) {
        super(recipeList, user);
        this.allergy = allergy;
    }




    public ArrayList<Recipe> pick_up(String type, String product) throws IOException {
        answer = recipeList.search(type, user.getAvail_products(), product);

        for(String all: allergy) {
            answer = search_all(answer, all);
        }
        return answer;
    }

    protected ArrayList<Recipe> search_all(ArrayList<Recipe> answer, String all){
        ArrayList<Recipe> answer_new = new ArrayList<Recipe>();
            System.out.println(all);
            for (Recipe ans : answer) {
                System.out.println(ans.getName());
                int counter = 0;
                for (String ingr : ans.getIngredients()) {
                    System.out.println(ingr+"-----"+all);
                    if (ingr.equals(all)) {
                        counter++;
                        System.out.println("-----");
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
