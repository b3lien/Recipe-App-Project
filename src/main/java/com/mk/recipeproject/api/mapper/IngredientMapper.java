package com.mk.recipeproject.api.mapper;

import com.mk.recipeproject.api.model.IngredientDTO;
import com.mk.recipeproject.model.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientMapper {

    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    IngredientDTO ingredientToIngredientDTO(Ingredient ingredient);

    Ingredient ingredientDTOToIngredient(IngredientDTO ingredientDTO);
}
