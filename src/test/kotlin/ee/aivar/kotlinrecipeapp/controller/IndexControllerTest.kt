package ee.aivar.kotlinrecipeapp.controller

import ee.aivar.kotlinrecipeapp.service.RecipeService
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.ArgumentMatchers.anySet
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.springframework.ui.Model

class IndexControllerTest {

    @Mock
    lateinit var recipeService : RecipeService

    @Mock
    lateinit var model : Model

    lateinit var indexController : IndexController

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        indexController = IndexController(recipeService)
    }

    @Test
    fun `should return index page string`() {

        val viewName = indexController.getIndexPage(model)

        assertEquals("index", viewName)
        verify(recipeService, times(1)).getRecipes()
        verify(model, times(1)).addAttribute(eq("recipes"), anySet<String>())
    }

}
