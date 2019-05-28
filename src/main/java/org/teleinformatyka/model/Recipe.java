package org.teleinformatyka.model;

public class Recipe {
    private String title;
    private String ingredients;
    private String instructions;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }


    @Override
    public String toString() {
        return
                "\n"+"title"+"\n"+  title  +
                "\n"+"ingredients" +"\n"+ ingredients  +
                "\n"+"instructions" +"\n"+ instructions;
    }
}
