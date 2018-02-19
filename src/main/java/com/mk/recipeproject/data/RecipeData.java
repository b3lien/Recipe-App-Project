package com.mk.recipeproject.data;

import com.mk.recipeproject.model.*;
import com.mk.recipeproject.model.user.Role;
import com.mk.recipeproject.repositories.RecipeRepository;
import com.mk.recipeproject.repositories.RoleRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class RecipeData implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;
    private final RoleRepository roleRepository;

    public RecipeData(RecipeRepository recipeRepository, RoleRepository roleRepository) {
        this.recipeRepository = recipeRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        List<Recipe> recipes = new ArrayList<>();

        //Spicy Grilled Chicken Tacos
        Recipe chickenRecipe = new Recipe();
        chickenRecipe.setDescription("Spicy Grilled Chicken Tacos");
        chickenRecipe.setPrepTime(20);
        chickenRecipe.setCookTime(15);
        chickenRecipe.setServings(4);
        chickenRecipe.setUrl("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        chickenRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat." +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, " +
                "garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over." +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings. 3 Grill the chicken: Grill the chicken " +
                "for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes." +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets " +
                "of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side. Wrap warmed tortillas in " +
                "a tea towel to keep them warm until serving. 5 Assemble the tacos: Slice the chicken into strips. On each tortilla, " +
                "place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
        chickenRecipe.setDifficulty(Difficulty.EASY);
        chickenRecipe.addIngredients(new Ingredient("2 tablespoons ancho chili powder, 1 teaspoon dried oregano, 1 teaspoon dried cumin, 1 teaspoon sugar," +
            " 1/2 teaspoon salt, 1 clove garlic, finely chopped," +
            " 1 tablespoon finely grated orange zest, 3 tablespoons fresh-squeezed orange juice, 2 tablespoons olive oil," +
            "4 to 6 skinless, boneless chicken thighs (1 1/4 pounds)"));
        Notes chickenNotes = new Notes();
        chickenNotes.setRecipeNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store," +
                                    " on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with" +
                                    " 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)");
        chickenRecipe.addNotes(chickenNotes);
        Category chickenCategories = new Category();
        chickenCategories.setRecipeCategories("American, Mexican, Fast Food, Fit");
        chickenRecipe.addCategories(chickenCategories);
        //add chicken recipe to list
        recipes.add(chickenRecipe);

        //How to Make Perfect Guacamole
        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("How to Make Perfect Guacamole");
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(10);
        guacamoleRecipe.setServings(3);
        guacamoleRecipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamoleRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a " + "" +
                "blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl." +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide " +
                "some balance to the richness of the avocado and will help delay the avocados from turning brown." +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half " +
                "of one chili pepper and add to the guacamole to your desired degree of hotness." +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste." +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. " +
                "(The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve." +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.addIngredients(new Ingredient("2 ripe avocados, 1/2 teaspoon Kosher salt, 1 Tbsp of fresh lime juice or lemon juice, " +
            "2 Tbsp to 1/4 cup of minced red onion or thinly sliced green onion," +
            " 1-2 serrano chiles, stems and seeds removed, minced, 2 tablespoons cilantro (leaves and tender stems), " + "" +
            "finely chopped, A dash of freshly grated black pepper, 1/2 ripe tomato, seeds and pulp removed, chopped"));
        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not " +
                "touch your eyes or the area near your eyes with your hands for several hours.");
        guacamoleRecipe.addNotes(guacamoleNotes);
        Category guacamoleCategories = new Category();
        guacamoleCategories.setRecipeCategories("American, Mexican, Party, Fast");
        guacamoleRecipe.addCategories(guacamoleCategories);

        //add guacamole recipe to list
        recipes.add(guacamoleRecipe);

        recipeRepository.save(recipes);

        addRoles();
    }

    private void addRoles(){
        Role userRole = new Role();
        userRole.setId(1);
        userRole.setRole("USER");
        roleRepository.save(userRole);

        Role superUserRole = new Role();
        userRole.setId(2);
        userRole.setRole("SUPER_USER");
        roleRepository.save(superUserRole);

        Role adminRole = new Role();
        adminRole.setId(3);
        adminRole.setRole("ADMIN");
        roleRepository.save(adminRole);
    }
}
