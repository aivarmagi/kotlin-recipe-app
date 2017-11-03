package ee.aivar.kotlinrecipeapp.service

import ee.aivar.kotlinrecipeapp.domain.Recipe
import org.springframework.stereotype.Service

@Service
interface RecipeService {

    fun getRecipes() : Set<Recipe>
}
