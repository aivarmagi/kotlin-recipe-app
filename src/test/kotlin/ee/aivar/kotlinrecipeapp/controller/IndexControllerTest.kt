package ee.aivar.kotlinrecipeapp.controller

import ee.aivar.kotlinrecipeapp.domain.Recipe
import ee.aivar.kotlinrecipeapp.service.RecipeService
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.Mockito.`when` as _when
import org.mockito.MockitoAnnotations
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.view
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.ui.Model

class IndexControllerTest {

    @Mock
    lateinit var recipeService : RecipeService

    @Mock
    lateinit var model : Model

    lateinit var indexController : IndexController

    inline fun <reified T : Any> argumentCaptor() = ArgumentCaptor.forClass(T::class.java)

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        indexController = IndexController(recipeService)
    }

    @Test
    fun `should pass MockMVC controller test`() {
        val mockMvc : MockMvc = MockMvcBuilders.standaloneSetup(indexController).build()

        mockMvc.perform(get("/"))
                .andExpect(status().isOk)
                .andExpect(view().name("index"))
    }

    @Test
    fun `should return index page string`() {

        val recipe = Recipe()
        recipe.description = "a description"
        val recipes = setOf(recipe, Recipe())

        _when(recipeService.getRecipes()).thenReturn(recipes)

        val recipeArgumentCaptor = argumentCaptor<() -> Set<Recipe>>()

        val viewName = indexController.getIndexPage(model)

        assertEquals("index", viewName)
        verify(recipeService, times(1)).getRecipes()
        verify(model, times(1)).addAttribute(eq("recipes"), recipeArgumentCaptor.capture())

        val setInController = recipeArgumentCaptor.value as Set<*>
        assertEquals(2, setInController.size)
    }

}
