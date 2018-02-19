package com.mk.recipeproject.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String recipeIngredients;

    @OneToOne
    private Recipe recipe;

    public Ingredient(String recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public Ingredient() {
    }
}
