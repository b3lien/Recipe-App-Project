package com.mk.recipeproject.repositories;

import com.mk.recipeproject.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
