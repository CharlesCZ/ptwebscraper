package org.teleinformatyka.api.model;

public class RecipeTags {

    private String recipeUrl;
    private String titleClass;
    private String titleXPath;
    private String ingredientsClass;
    private String ingredientXPath;
    private String instructionsClass;
    private String instructionsXPath;

    public RecipeTags() {
    }

    public RecipeTags(String recipeUrl, String titleClass, String titleXPath, String ingredientsClass, String ingredientXPath, String instructionsClass, String instructionsXPath) {
        this.recipeUrl = recipeUrl;
        this.titleClass = titleClass;
        this.titleXPath = titleXPath;
        this.ingredientsClass = ingredientsClass;
        this.ingredientXPath = ingredientXPath;
        this.instructionsClass = instructionsClass;
        this.instructionsXPath = instructionsXPath;
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
}
