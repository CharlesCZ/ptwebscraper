package org.teleinformatyka.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.teleinformatyka.domain.Recipe;

import java.util.List;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, String> {

    Recipe findByTitle(String title);

}
