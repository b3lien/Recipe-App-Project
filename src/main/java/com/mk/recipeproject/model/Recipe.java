package com.mk.recipeproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String url;

    @Lob
    private String directions;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Ingredient ingredients;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToOne(cascade = CascadeType.ALL)
    private Category categories;

    public Recipe() {
    }

    public Recipe(Long id) {
        this.id = id;
    }

    public void addIngredients (Ingredient ingredients) {
        if (ingredients != null) {
            this.ingredients = ingredients;
            ingredients.setRecipe(this);
        }
    }

    public void addNotes(Notes notes) {
        if (notes != null) {
            this.notes = notes;
            notes.setRecipe(this);
        }
    }

    public void addCategories(Category categories) {
        if (categories != null) {
            this.categories = categories;
            categories.setRecipe(this);
        }
    }

}
