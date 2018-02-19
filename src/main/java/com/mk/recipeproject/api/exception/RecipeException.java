package com.mk.recipeproject.api.exception;

public class RecipeException extends Exception {

    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public RecipeException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public RecipeException() {
        super();
    }
}
