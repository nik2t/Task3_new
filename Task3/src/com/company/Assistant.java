package com.company;

import java.io.IOException;
import java.util.ArrayList;


public class Assistant {
    protected RecipeList recipeList;
    protected User user;
    private  Questions questions = new Questions("Готовим завтрак, обед или ужин?", "Какой продукт должен быть в рецепте?");
    protected     ArrayList<Recipe> answer;

    public Assistant(RecipeList recipeList, User user) {
        this.recipeList = recipeList;
        this.user = user;

    }
    public Assistant() { }

    public void setAnswer(ArrayList<Recipe> answer) {
        this.answer = answer;
    }

    public ArrayList<Recipe> getAnswer() {
        return answer;
    }

    public void delAnswer(){
        answer = new ArrayList<Recipe>();
    }

    public ArrayList<Recipe> pick_up(String type, String product) throws IOException {
        answer = recipeList.search(type, user.getAvail_products(), product);
       return answer;
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

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }


}
