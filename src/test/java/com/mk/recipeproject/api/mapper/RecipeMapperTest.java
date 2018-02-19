package com.mk.recipeproject.api.mapper;

import com.mk.recipeproject.api.model.RecipeDTO;
import com.mk.recipeproject.model.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeMapperTest {

    private RecipeMapper recipeMapper = RecipeMapper.INSTANCE;

    @Test
    public void recipeToRecipeDTO() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setDescription("description");
        recipe.setPrepTime(20);
        recipe.setCookTime(15);
        recipe.setServings(2);
        recipe.setUrl("www.a.com");
        recipe.setDirections("directions");

        RecipeDTO recipeDTO = recipeMapper.recipeToRecipeDTO(recipe);
        assertEquals(recipe.getId(), recipeDTO.getId());
        assertEquals(recipe.getDescription(), recipeDTO.getDescription());
        assertEquals(recipe.getPrepTime(), recipeDTO.getPrepTime());
        assertEquals(recipe.getCookTime(), recipeDTO.getCookTime());
        assertEquals(recipe.getServings(), recipeDTO.getServings());
        assertEquals(recipe.getUrl(), recipeDTO.getUrl());
        assertEquals(recipe.getDirections(), recipeDTO.getDirections());

    }

    @Test
    public void recipeDTOToRecipe() {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(2L);
        recipeDTO.setDescription("descriptionDTO");
        recipeDTO.setPrepTime(25);
        recipeDTO.setCookTime(10);
        recipeDTO.setServings(5);
        recipeDTO.setUrl("www.aDTO.com");
        recipeDTO.setDirections("directionsDTO");

        Recipe recipe = recipeMapper.recipeDTOToRecipe(recipeDTO);
        assertEquals(recipeDTO.getId(), recipe.getId());
        assertEquals(recipeDTO.getDescription(), recipe.getDescription());
        assertEquals(recipeDTO.getPrepTime(), recipe.getPrepTime());
        assertEquals(recipeDTO.getCookTime(), recipe.getCookTime());
        assertEquals(recipeDTO.getServings(), recipe.getServings());
        assertEquals(recipeDTO.getUrl(), recipe.getUrl());
        assertEquals(recipeDTO.getDirections(), recipe.getDirections());

    }
}