package com.mk.recipeproject.service;

import com.mk.recipeproject.api.mapper.*;
import com.mk.recipeproject.api.model.RecipeDTO;
import com.mk.recipeproject.model.Recipe;
import com.mk.recipeproject.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeApiServiceImpl implements RecipeApiService {

    private RecipeRepository recipeRepository;
    private RecipeMapper recipeMapper;

    public RecipeApiServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public List<RecipeDTO> getAllRecipes() {
        return recipeRepository.findAll()
                                .stream()
                                .map(recipe -> recipeMapper.recipeToRecipeDTO(recipe))
                                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO getRecipeById(Long id) {
        Recipe recipe = recipeRepository.findOne(id);
        return recipeMapper.recipeToRecipeDTO(recipe);
    }

    private RecipeDTO saveAndReturnDTO(Recipe recipe) {
        Recipe savedRecipe = recipeRepository.save(recipe);
        return recipeMapper.recipeToRecipeDTO(savedRecipe);
    }

    @Override
    public RecipeDTO createNewRecipe(RecipeDTO recipeDTO) {
        return saveAndReturnDTO(recipeMapper.recipeDTOToRecipe(recipeDTO));
    }

    @Override
    public RecipeDTO saveRecipeByDTO(Long id, RecipeDTO recipeDTO) {
        Recipe recipe = recipeMapper.recipeDTOToRecipe(recipeDTO);
        recipe.setId(id);
        return saveAndReturnDTO(recipe);
    }

    @Override
    public void deleteRecipeById(Long id) {
        recipeRepository.delete(id);
    }

}
