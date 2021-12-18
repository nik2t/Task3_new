package com.company;

import java.util.ArrayList;

import static java.lang.System.exit;

public class Recipe {

    protected  String[] ingredients;
    protected  String actions;
    protected  String name;
    protected    String type;


    public Recipe(){}

    public Recipe(String name, String type,String[] ingredients, String actions) {
        this.ingredients = ingredients;
        this.actions = actions;
        this.name = name;
        this.type = type;
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
            System.out.println("\n"+ actions+"\n");
        }
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
