package com.mk.recipeproject.controllers;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void verifyAllRecipes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/recipe").accept(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(2))).andDo(print());
    }

    @Test
    public void verifyRecipeById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/recipe/1").accept(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.description").exists())
            .andExpect(jsonPath("$.prepTime").exists())
            .andExpect(jsonPath("$.cookTime").exists())
            .andExpect(jsonPath("$.servings").exists())
            .andExpect(jsonPath("$.url").exists())
            .andExpect(jsonPath("$.directions").exists())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.description").value("Spicy Grilled Chicken Tacos"))
            .andExpect(jsonPath("$.prepTime").value(20))
            .andExpect(jsonPath("$.cookTime").value(15))
            .andExpect(jsonPath("$.servings").value(4))
            .andExpect(jsonPath("$.url").value("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/"))
            .andExpect(jsonPath("$.directions").value("1 Prepare a gas or charcoal grill for medium-high, direct heat." +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, " +
                "garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over." +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings. 3 Grill the chicken: Grill the chicken " +
                "for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes." +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets " +
                "of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side. Wrap warmed tortillas in " +
                "a tea towel to keep them warm until serving. 5 Assemble the tacos: Slice the chicken into strips. On each tortilla, " +
                "place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges."));
    }

    @Test
    public void verifyInvalidRecipeArgument() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/recipe/r").accept(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.errorCode").value(400))
            .andExpect(jsonPath("$.message").value("The request could not be understood by the server due to malformed syntax."))
            .andDo(print());
    }

    @Test
    public void verifyInvalidRecipeId() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/recipe/0").accept(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.errorCode").value(404))
            .andExpect(jsonPath("$.message").value("Recipe doesn't exist."))
            .andDo(print());
    }

    @Test
    public void verifyNullRecipe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/recipe/6").accept(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.errorCode").value(404))
            .andExpect(jsonPath("$.message").value("Recipe doesn't exist."))
            .andDo(print());
    }

    @Test
    public void verifyDeleteById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/recipe/2").accept(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.message").value("Recipe has been deleted."))
            .andDo(print());
    }

    @Test
    public void verifyInvalidRecipeToDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/recipe/0").accept(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.errorCode").value(404))
            .andExpect(jsonPath("$.message").value("Recipe to delete doesn't exist."))
            .andDo(print());
    }

    @Test
    public void verifySaveRecipe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/recipe").contentType(MediaType.APPLICATION_JSON)
            .content("{\"description\" : \"Description\", \"prepTime\" : \"20\", \"cookTime\" : \"10\", \"servings\" : \"5\"}")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.description").exists())
            .andExpect(jsonPath("$.prepTime").exists())
            .andExpect(jsonPath("$.cookTime").exists())
            .andExpect(jsonPath("$.servings").exists())
            .andExpect(jsonPath("$.description").value("Description"))
            .andExpect(jsonPath("$.prepTime").value(20))
            .andExpect(jsonPath("$.cookTime").value(10))
            .andExpect(jsonPath("$.servings").value(5))
            .andDo(print());
    }

    @Test
    public void verifyUpdateRecipe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/recipe/1").contentType(MediaType.APPLICATION_JSON)
            .content("{\"id\" : \"1\", \"description\" : \"New Description\", \"prepTime\" : \"200\", \"cookTime\" : \"100\", \"servings\" : \"50\"}")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.description").exists())
            .andExpect(jsonPath("$.prepTime").exists())
            .andExpect(jsonPath("$.cookTime").exists())
            .andExpect(jsonPath("$.servings").exists())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.description").value("New Description"))
            .andExpect(jsonPath("$.prepTime").value(200))
            .andExpect(jsonPath("$.cookTime").value(100))
            .andExpect(jsonPath("$.servings").value(50))
            .andDo(print());
    }

    @Test
    public void verifyInvalidRecipeToUpdate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/recipe/0").contentType(MediaType.APPLICATION_JSON)
            .content("{\"id\" : \"0\", \"description\" : \"Description\", \"prepTime\" : \"15\", \"cookTime\" : \"45\", \"servings\" : \"2\"}")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.errorCode").value(404))
            .andExpect(jsonPath("$.message").value("Recipe to update doesn't exist."))
            .andDo(print());
    }
}