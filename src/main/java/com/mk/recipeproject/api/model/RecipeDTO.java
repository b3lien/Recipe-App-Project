package com.mk.recipeproject.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDTO {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String url;
    private String directions;
    @JsonProperty("difficulty")
    private DifficultyDTO difficultyDTO;
    @JsonProperty("ingredients")
    private IngredientDTO ingredientsDTO;
    @JsonProperty("notes")
    private NotesDTO notesDTO;
    @JsonProperty("categories")
    private CategoryDTO categoriesDTO;
}
