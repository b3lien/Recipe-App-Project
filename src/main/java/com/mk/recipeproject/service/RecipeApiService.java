package com.mk.recipeproject.service;

import com.mk.recipeproject.api.model.RecipeDTO;
import com.mk.recipeproject.model.Recipe;

import java.util.List;

public interface RecipeApiService {

    List<RecipeDTO> getAllRecipes();

    RecipeDTO getRecipeById(Long id);

    RecipeDTO createNewRecipe(RecipeDTO recipeDTO);

    RecipeDTO saveRecipeByDTO(Long id, RecipeDTO recipeDTO);

    void deleteRecipeById(Long id);
}
