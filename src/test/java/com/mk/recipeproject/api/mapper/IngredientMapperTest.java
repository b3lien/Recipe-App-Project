package com.mk.recipeproject.api.mapper;

import com.mk.recipeproject.api.model.IngredientDTO;
import com.mk.recipeproject.model.Ingredient;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientMapperTest {

    private IngredientMapper ingredientMapper = IngredientMapper.INSTANCE;

    @Test
    public void ingredientToIngredientDTO() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setRecipeIngredients("tomato");

        IngredientDTO ingredientDTO = ingredientMapper.ingredientToIngredientDTO(ingredient);
        assertEquals(ingredient.getId(), ingredientDTO.getId());
        assertEquals(ingredient.getRecipeIngredients(), ingredientDTO.getRecipeIngredients());
    }

    @Test
    public void ingredientDTOToIngredient() {
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setId(2L);
        ingredientDTO.setRecipeIngredients("onion");

        Ingredient ingredient = ingredientMapper.ingredientDTOToIngredient(ingredientDTO);
        assertEquals(ingredientDTO.getId(),ingredient.getId());
        assertEquals(ingredientDTO.getRecipeIngredients(), ingredient.getRecipeIngredients());
    }
}