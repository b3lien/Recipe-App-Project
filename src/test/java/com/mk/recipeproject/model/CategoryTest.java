package com.mk.recipeproject.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    private Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        Long idValue = 4L;
        category.setId(idValue);
        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() {
        String description = "Some description";
        category.setRecipeCategories(description);
        assertEquals(description,category.getRecipeCategories());
    }

    @Test
    public void getRecipe() {
        Recipe recipe = new Recipe();
        category.setRecipe(recipe);
        assertEquals(recipe, category.getRecipe());
    }

}