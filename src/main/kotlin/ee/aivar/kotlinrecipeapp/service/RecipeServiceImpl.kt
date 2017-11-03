package ee.aivar.kotlinrecipeapp.service

import ee.aivar.kotlinrecipeapp.domain.Recipe
import ee.aivar.kotlinrecipeapp.repository.RecipeRepository
import org.springframework.stereotype.Service

@Service
class RecipeServiceImpl(val recipeRepository: RecipeRepository) : RecipeService {

    override fun getRecipes(): Set<Recipe> {

        return recipeRepository.findAll().reversed().toHashSet()
    }
}
