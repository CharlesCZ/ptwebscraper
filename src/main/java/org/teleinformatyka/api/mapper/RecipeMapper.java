package org.teleinformatyka.api.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.teleinformatyka.api.model.RecipeTags;
import org.teleinformatyka.domain.Recipe;

@Mapper
public interface RecipeMapper {

    RecipeMapper INSTANCE= Mappers.getMapper(RecipeMapper.class);

    RecipeTags recipeToRecipeTags(Recipe recipe);

    Recipe recipeTagsToRecipe(RecipeTags recipeTags);



}
