package com.mk.recipeproject.api.mapper;

import com.mk.recipeproject.api.model.*;
import com.mk.recipeproject.model.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipeMapper {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    @Mappings({
        @Mapping(target = "notesDTO", source = "notes"),
        @Mapping(target = "ingredientsDTO", source = "ingredients"),
        @Mapping(target = "difficultyDTO", source = "difficulty"),
        @Mapping(target = "categoriesDTO", source = "categories")
    })
    RecipeDTO recipeToRecipeDTO(Recipe recipe);

    @InheritInverseConfiguration
    Recipe recipeDTOToRecipe(RecipeDTO recipeDTO);

    NotesDTO notesToNotesDTO(Notes notes);

    Notes notesDTOToNotes(NotesDTO notesDTO);

    IngredientDTO ingredientToIngredientDTO(Ingredient ingredient);

    Ingredient ingredientDTOToIngredient(IngredientDTO ingredientDTO);

    DifficultyDTO difficultyToDifficultyDTO(Difficulty difficulty);

    Difficulty difficultyDTOToDifficulty(DifficultyDTO difficultyDTO);

    CategoryDTO categoryToCategoryDTO(Category category);

    Category categoryDTOToCategory(CategoryDTO categoryDTO);

}
