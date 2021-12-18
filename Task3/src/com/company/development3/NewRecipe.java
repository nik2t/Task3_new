package com.company.development3;

import com.company.Recipe;

public class NewRecipe extends Recipe {
    protected String[] appliances;

    public NewRecipe(String name, String type,String[] ingredients, String actions, String[] appliances) {
        super( name, type,ingredients, actions);
        this.appliances = appliances;
    }

    public void print(){
        if(name == null || type == null || ingredients == null){
            System.out.println("Нет действующего рецепта");

        }
        else {
            System.out.println(name + " "+ type+":"+"\n");
            for(String ingr : ingredients){
                System.out.print(ingr+",");
            }
            for(String appl : appliances){
                System.out.print(appl+",");
            }
            System.out.println("\n"+ actions+"\n");
        }
    }

    public String[] getAppliances() {
        return appliances;
    }

    public void setAppliances(String[] appliances) {
        this.appliances = appliances;
    }
}
