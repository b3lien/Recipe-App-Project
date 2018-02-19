package com.mk.recipeproject.service;

import com.mk.recipeproject.model.Recipe;
import com.mk.recipeproject.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe(1L));
        recipes.add(new Recipe(2L));
        recipes.add(new Recipe(3L));
        when(recipeRepository.findAll()).thenReturn(recipes);
        Set<Recipe> recipeSet= recipeService.getRecipes();
        assertEquals(3, recipeSet.size());
    }

    @Test
    public void findById() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeRepository.findOne(anyLong())).thenReturn(recipe);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned",recipeReturned);
        verify(recipeRepository,times(1)).findOne(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void saveRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setDescription("Description");
        recipe.setServings(4);
        when(recipeRepository.save(recipe)).thenReturn(recipe);
        Recipe saved = recipeService.saveRecipe(recipe);
        assertEquals(recipe.getId(), saved.getId());
        assertEquals(recipe.getDescription(), saved.getDescription());
        assertEquals(recipe.getServings(), saved.getServings());
    }

    @Test
    public void deleteByID() {
        Long idToDelete = 2L;

        recipeService.deleteById(idToDelete);

        verify(recipeRepository, times(1)).delete(anyLong());
    }
}
