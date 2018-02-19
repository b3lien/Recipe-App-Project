package com.mk.recipeproject.service;

import com.mk.recipeproject.model.Recipe;
import com.mk.recipeproject.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        List<Recipe> recipeList = recipeRepository.findAll();
        return new HashSet<>(recipeList);
    }

    @Override
    public Recipe findById(Long l) {
        return recipeRepository.findOne(l);
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void deleteById(Long l) {
        recipeRepository.delete(l);
    }

}
