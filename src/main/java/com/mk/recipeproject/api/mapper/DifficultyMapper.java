package com.mk.recipeproject.api.mapper;

import com.mk.recipeproject.api.model.DifficultyDTO;
import com.mk.recipeproject.model.Difficulty;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DifficultyMapper {

    DifficultyMapper INSTANCE = Mappers.getMapper(DifficultyMapper.class);

    DifficultyDTO difficultyToDifficultyDTO(Difficulty difficulty);

    Difficulty difficultyDTOToDifficulty(DifficultyDTO difficultyDTO);
}
