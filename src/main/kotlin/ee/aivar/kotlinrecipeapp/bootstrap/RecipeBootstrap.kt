package ee.aivar.kotlinrecipeapp.bootstrap

import ee.aivar.kotlinrecipeapp.domain.*
import ee.aivar.kotlinrecipeapp.repository.CategoryRepository
import ee.aivar.kotlinrecipeapp.repository.RecipeRepository
import ee.aivar.kotlinrecipeapp.repository.UnitOfMeasureRepository
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.util.*

@Component
class RecipeBootstrap (val categoryRepository: CategoryRepository,
                       val recipeRepository: RecipeRepository,
                       val unitOfMeasureRepository: UnitOfMeasureRepository) : ApplicationListener<ContextRefreshedEvent>{

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes())
        println("Recipes bootstrapped to Context")
    }

    fun getRecipes() : List<Recipe> {

        val teaSpoonUomOptional : Optional<UnitOfMeasure> = unitOfMeasureRepository.findByDescription("Teaspoon")
        if (!teaSpoonUomOptional.isPresent) {
            throw RuntimeException("Expected UOM not found!")
        }

        val tableSpoonUomOptional : Optional<UnitOfMeasure> = unitOfMeasureRepository.findByDescription("Tablespoon")
        if (!tableSpoonUomOptional.isPresent) {
            throw RuntimeException("Expected UOM not found!")
        }

        val cupUomOptional : Optional<UnitOfMeasure> = unitOfMeasureRepository.findByDescription("Cup")
        if (!cupUomOptional.isPresent) {
            throw RuntimeException("Expected UOM not found!")
        }

        val pinchUomOptional :Optional<UnitOfMeasure> = unitOfMeasureRepository.findByDescription("Pinch")
        if (!pinchUomOptional.isPresent) {
            throw RuntimeException("Expected UOM not found!")
        }

        val ounceUomOptional : Optional<UnitOfMeasure> = unitOfMeasureRepository.findByDescription("Ounce")
        if (!ounceUomOptional.isPresent) {
            throw RuntimeException("Expected UOM not found!")
        }

        val eachUomOptional : Optional<UnitOfMeasure> = unitOfMeasureRepository.findByDescription("Each")
        if (!eachUomOptional.isPresent) {
            throw RuntimeException("Expected UOM not found!")
        }

        val dashUomOptional : Optional<UnitOfMeasure> = unitOfMeasureRepository.findByDescription("Dash")
        if (!dashUomOptional.isPresent) {
            throw RuntimeException("Expected UOM not found!")
        }

        val pintUomOptional : Optional<UnitOfMeasure> = unitOfMeasureRepository.findByDescription("Pint")
        if (!pintUomOptional.isPresent) {
            throw RuntimeException("Expected UOM not found!")
        }

        val teaSpoonUom : UnitOfMeasure = teaSpoonUomOptional.get()
        val tableSpoonUom : UnitOfMeasure = tableSpoonUomOptional.get()
        val cupUom : UnitOfMeasure = cupUomOptional.get()
        val eachUom : UnitOfMeasure = eachUomOptional.get()
        val dashUom : UnitOfMeasure = dashUomOptional.get()
        val pintUom : UnitOfMeasure = pintUomOptional.get()

        val americanCategoryOptional : Optional<Category> = categoryRepository.findByDescription("American")
        if (!americanCategoryOptional.isPresent) {
            throw RuntimeException("Expected UOM not found!")
        }

        val mexicanCategoryOptional : Optional<Category> = categoryRepository.findByDescription("Mexican")
        if (!mexicanCategoryOptional.isPresent) {
            throw RuntimeException("Expected UOM not found!")
        }

        val americanCategory : Category = americanCategoryOptional.get()
        val mexicanCategory : Category = mexicanCategoryOptional.get()

        val guacamoleRecipe = Recipe()
        guacamoleRecipe.description = "Perfect Guacamole"
        guacamoleRecipe.prepTime = 10
        guacamoleRecipe.cookTime = 0
        guacamoleRecipe.difficulty = Difficulty.EASY
        guacamoleRecipe.directions = "1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon.  Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n"

        guacamoleRecipe.url = "http://www.simplyrecipes.com/recipes/perfect_guacamole/"
        guacamoleRecipe.servings = 4
        guacamoleRecipe.source = "Simply recipes"

        val guacamoleNotes = Notes()
        guacamoleNotes.recipeNotes = "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great."
        guacamoleRecipe.notes = guacamoleNotes

        guacamoleRecipe.ingredients = hashSetOf(
            Ingredient("ripe avocados", BigDecimal(2), eachUom, guacamoleRecipe),
            Ingredient("Kosher salt", BigDecimal(0.5), teaSpoonUom, guacamoleRecipe),
            Ingredient("of fresh lime juice or lemon juice", BigDecimal(1), tableSpoonUom, guacamoleRecipe),
            Ingredient("of minced red onion or thinly sliced green onion", BigDecimal(2), tableSpoonUom, guacamoleRecipe),
            Ingredient("serrano chiles, stems and seeds removed, minced", BigDecimal(2), eachUom, guacamoleRecipe),
            Ingredient("cilantro (leaves and tender stems), finely chopped", BigDecimal(2), tableSpoonUom, guacamoleRecipe),
            Ingredient("of freshly grated black pepper", BigDecimal(1), dashUom, guacamoleRecipe),
            Ingredient("ripe tomato, seeds and pulp removed, chopped", BigDecimal(0.5), eachUom, guacamoleRecipe)
        )

        guacamoleRecipe.categories = hashSetOf(americanCategory, mexicanCategory)

        // // // // // // // // // // // // // // // // // //
        val tacoRecipe = Recipe()
        tacoRecipe.description = "Spicy Grilled Chicken Tacos"
        tacoRecipe.prepTime = 20
        tacoRecipe.cookTime = 15
        tacoRecipe.difficulty = Difficulty.EASY
        tacoRecipe.directions = "1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n"
        tacoRecipe.url = "http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/"
        tacoRecipe.servings = 4
        tacoRecipe.source = "Simply recipes"

        val tacoNotes = Notes()
        tacoNotes.recipeNotes = "Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)"
        tacoRecipe.notes = tacoNotes

        tacoRecipe.ingredients = hashSetOf(
            //for the chicken
            Ingredient("ancho chili powder", BigDecimal(2), tableSpoonUom, tacoRecipe),
            Ingredient("dried oregano", BigDecimal(1), teaSpoonUom, tacoRecipe),
            Ingredient("dried cumin", BigDecimal(1), teaSpoonUom, tacoRecipe),
            Ingredient("sugar", BigDecimal(1), teaSpoonUom, tacoRecipe),
            Ingredient("salt", BigDecimal(0.5), teaSpoonUom, tacoRecipe),
            Ingredient("finely grated orange zest", BigDecimal(1), tableSpoonUom, tacoRecipe),
            Ingredient("fresh-squeezed orange juice", BigDecimal(3), tableSpoonUom, tacoRecipe),
            Ingredient("olive oil", BigDecimal(2), tableSpoonUom, tacoRecipe),
            Ingredient("skinless, boneless chicken thighs (1 1/4 pounds)", BigDecimal(6), eachUom, tacoRecipe),

            //to serve
            Ingredient("small corn tortillas", BigDecimal(8), eachUom, tacoRecipe),
            Ingredient("packed baby arugula (3 ounces)", BigDecimal(3), cupUom, tacoRecipe),
            Ingredient("medium ripe avocados, sliced", BigDecimal(2), eachUom, tacoRecipe),
            Ingredient("radishes, thinly sliced", BigDecimal(4), eachUom, tacoRecipe),
            Ingredient("cherry tomatoes, halved", BigDecimal(0.5), pintUom, tacoRecipe),
            Ingredient("red onion, thinly sliced", BigDecimal(0.25), eachUom, tacoRecipe),
            Ingredient("Roughly chopped cilantro", BigDecimal(1), eachUom, tacoRecipe),
            Ingredient("sour cream thinned with 1/4 cup milk", BigDecimal(0.5), cupUom, tacoRecipe),
            Ingredient("lime, cut into wedges", BigDecimal(1), eachUom, tacoRecipe)
        )

        tacoRecipe.categories = hashSetOf(americanCategory, mexicanCategory)

        val recipes : List<Recipe> = arrayListOf(guacamoleRecipe, tacoRecipe)

        return recipes
    }
}
