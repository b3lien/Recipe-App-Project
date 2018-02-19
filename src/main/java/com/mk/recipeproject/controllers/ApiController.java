package com.mk.recipeproject.controllers;

import com.mk.recipeproject.api.model.RecipeDTO;
import com.mk.recipeproject.api.exception.RecipeException;
import com.mk.recipeproject.api.model.Response;
import com.mk.recipeproject.service.RecipeApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "Recipe Rest API Controller")
@RestController
@RequestMapping("/api/recipe")
public class ApiController {

    private RecipeApiService recipeApiService;

    public ApiController(RecipeApiService recipeApiService) {
        this.recipeApiService = recipeApiService;
    }

    @ApiOperation(value = "Get list of all recipes.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RecipeDTO> listAllRecipes(){
        return recipeApiService.getAllRecipes();
    }

    @ApiOperation(value = "Get recipe by Id.")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RecipeDTO showById(@PathVariable Long id) throws RecipeException {
        RecipeDTO recipe = recipeApiService.getRecipeById(id);
        if (recipe == null || recipe.getId() <= 0){
            throw new RecipeException("Recipe doesn't exist.");
        }
        return recipe;
    }

    @ApiOperation(value = "Create a new recipe.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeDTO createNewRecipe(@RequestBody RecipeDTO recipeDTO){
        return recipeApiService.createNewRecipe(recipeDTO);
    }

    @ApiOperation(value = "Update existing recipe by Id.")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RecipeDTO updateRecipe(@PathVariable Long id, @RequestBody RecipeDTO recipeDTO) throws RecipeException{
        RecipeDTO recipe = recipeApiService.getRecipeById(id);
        if (recipe == null || recipe.getId() <= 0){
            throw new RecipeException("Recipe to update doesn't exist.");
        }
        return recipeApiService.saveRecipeByDTO(id, recipeDTO);
    }

    @ApiOperation(value = "Delete recipe by Id.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteRecipe(@PathVariable Long id) throws RecipeException{
        RecipeDTO recipe = recipeApiService.getRecipeById(id);
        if (recipe == null || recipe.getId() <= 0){
            throw new RecipeException("Recipe to delete doesn't exist.");
        }
        recipeApiService.deleteRecipeById(id);
        return new Response(HttpStatus.OK.value(), "Recipe has been deleted.");
    }

}
