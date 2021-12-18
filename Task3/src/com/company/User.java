package com.company;

public class User {
    protected AvailableProducts avail_products;
    protected MissingProducts miss_products;
    protected Recipe last_recipe;

    public User(AvailableProducts avail_products, MissingProducts miss_products) {
        this.avail_products = avail_products;
        this.miss_products = miss_products;
    }

    public void print(){
        last_recipe.print();
        System.out.println("----------------");
        for(String miss: miss_products.getProducts()){
            System.out.println(miss +",");
        }
    }

    public Recipe getLast_recipe() {
        return last_recipe;
    }

    public void setLast_recipe(Recipe last_recipe) {
        this.last_recipe = last_recipe;
    }

    public void delLast_recipe() {
        this.last_recipe = new Recipe();
        miss_products.getProducts().clear();
    }

    public AvailableProducts getAvail_products() {
        return avail_products;
    }

    public void setAvail_products(AvailableProducts avail_products) {
        this.avail_products = avail_products;
        for(String avail: avail_products.getProducts()){
            for(String miss: miss_products.getProducts()){
                if(avail.equals(miss)){
                    miss_products.getProducts().remove(miss);
                }
            }

        }
    }

    public MissingProducts getMiss_products() {
        return miss_products;
    }

    public void setMiss_products(MissingProducts miss_products) {
        this.miss_products = miss_products;
    }
}
