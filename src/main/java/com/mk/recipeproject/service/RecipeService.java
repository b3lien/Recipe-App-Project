package com.mk.recipeproject.service;

import com.mk.recipeproject.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    Recipe saveRecipe(Recipe recipe);

    void deleteById(Long l);

}
