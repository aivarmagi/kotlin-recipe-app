package ee.aivar.kotlinrecipeapp.controller

import ee.aivar.kotlinrecipeapp.domain.Recipe
import ee.aivar.kotlinrecipeapp.service.RecipeService
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.*
import org.mockito.Mock
import org.mockito.Mockito.anyLong
import org.mockito.Mockito.`when` as _when
import org.mockito.MockitoAnnotations
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.view
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class RecipeControllerTest {

    @Mock
    lateinit var recipeService : RecipeService

    lateinit var recipeController : RecipeController

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        recipeController = RecipeController(recipeService)
    }

    @Test
    fun `controller should return recipe`() {

        val recipe = Recipe()
        recipe.description = "description"

        val mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build()

        _when(recipeService.findById(anyLong())).thenReturn(recipe)

        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk)
                .andExpect(view().name("recipe/show"))
    }

}
