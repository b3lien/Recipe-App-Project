package com.mk.recipeproject.api.mapper;

import com.mk.recipeproject.api.model.CategoryDTO;
import com.mk.recipeproject.model.Category;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryMapperTest {

    private CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() {
        Category category = new Category();
        category.setId(1L);
        category.setRecipeCategories("mexican");

        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
        assertEquals(category.getId(), categoryDTO.getId());
        assertEquals(category.getRecipeCategories(), categoryDTO.getRecipeCategories());
    }

    @Test
    public void categoryDTOToCategory() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(2L);
        categoryDTO.setRecipeCategories("american");

        Category category = categoryMapper.categoryDTOToCategory(categoryDTO);
        assertEquals(categoryDTO.getId(), category.getId());
        assertEquals(categoryDTO.getRecipeCategories(), category.getRecipeCategories());
    }
}