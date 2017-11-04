package ee.aivar.kotlinrecipeapp.service

import ee.aivar.kotlinrecipeapp.domain.Recipe
import ee.aivar.kotlinrecipeapp.repository.RecipeRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.Mockito.`when` as _when
import org.mockito.MockitoAnnotations

class RecipeServiceImplTest {

    lateinit var recipeService: RecipeServiceImpl

    @Mock
    lateinit var recipeRepository: RecipeRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        recipeService = RecipeServiceImpl(recipeRepository)
    }

    @Test
    fun `should return all recipes`() {

        val recipe = Recipe()
        val recipesData = setOf(recipe, Recipe())

        _when(recipeService.getRecipes()).thenReturn(recipesData)

        val recipes = recipeService.getRecipes()

        assertEquals(recipes.size, 2)
        verify(recipeRepository, times(1)).findAll()
    }
}
