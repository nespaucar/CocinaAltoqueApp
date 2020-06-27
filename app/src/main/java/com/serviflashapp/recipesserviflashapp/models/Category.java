package com.serviflashapp.recipesserviflashapp.models;

public class Category {
    private int id;
    private int numRecipes;
    private int image;
    private String name;

    public Category(int id, int numRecipes, String name, int image) {
        this.id = id;
        this.numRecipes = numRecipes;
        this.name = name;
        this.image = image;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumRecipes() {
        return numRecipes;
    }

    public void setNumRecipes(int numRecipes) {
        this.numRecipes = numRecipes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
