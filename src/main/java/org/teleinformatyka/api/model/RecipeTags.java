package org.teleinformatyka.api.model;

public class RecipeTags {

    private String recipeUrl;
    private String titleClass;
    private String titleXPath;
    private String ingredientsClass;
    private String ingredientXPath;
    private String instructionsClass;
    private String instructionsXPath;
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

    public String getRecipeUrl() {
        return recipeUrl;
    }

    public void setRecipeUrl(String recipeUrl) {
        this.recipeUrl = recipeUrl;
    }

    public String getTitleClass() {
        return titleClass;
    }

    public void setTitleClass(String titleClass) {
        this.titleClass = titleClass;
    }

    public String getTitleXPath() {
        return titleXPath;
    }

    public void setTitleXPath(String titleXPath) {
        this.titleXPath = titleXPath;
    }

    public String getIngredientsClass() {
        return ingredientsClass;
    }

    public void setIngredientsClass(String ingredientsClass) {
        this.ingredientsClass = ingredientsClass;
    }

    public String getIngredientXPath() {
        return ingredientXPath;
    }

    public void setIngredientXPath(String ingredientXPath) {
        this.ingredientXPath = ingredientXPath;
    }

    public String getInstructionsClass() {
        return instructionsClass;
    }

    public void setInstructionsClass(String instructionsClass) {
        this.instructionsClass = instructionsClass;
    }

    public String getInstructionsXPath() {
        return instructionsXPath;
    }

    public void setInstructionsXPath(String instructionsXPath) {
        this.instructionsXPath = instructionsXPath;
    }


    @Override
    public String toString() {
        return
                "\n"+"title"+"\n"+  title  +
                        "\n"+"ingredients" +"\n"+ ingredients  +
                        "\n"+"instructions" +"\n"+ instructions;
    }
}
