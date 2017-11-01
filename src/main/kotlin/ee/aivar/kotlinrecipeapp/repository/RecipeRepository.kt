package ee.aivar.kotlinrecipeapp.repository

import ee.aivar.kotlinrecipeapp.domain.Recipe
import org.springframework.data.repository.CrudRepository

interface RecipeRepository : CrudRepository<Recipe, Long> {
}
