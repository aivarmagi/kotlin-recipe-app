package ee.aivar.kotlinrecipeapp.domain

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore

class CategoryTest {

    lateinit var category : Category

    @Before
    fun setUp() {
        category = Category()
    }

    @Test
    @Ignore
    fun `should return correct id`() {
        //not possible because BaseEntity-s id property is val
    }

    @Test
    fun `should return correct description`() {
        val description = "something something"

        category.description = description

        assertEquals(description, category.description)
    }

    @Test
    fun `should return recipe list`() {
        val recipe = Recipe()
        val recipes = setOf(recipe)

        category.recipes = recipes

        assertEquals(category.recipes.size, 1)
    }

}
