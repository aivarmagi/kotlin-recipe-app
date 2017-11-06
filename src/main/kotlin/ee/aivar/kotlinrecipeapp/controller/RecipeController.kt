package ee.aivar.kotlinrecipeapp.controller

import ee.aivar.kotlinrecipeapp.service.RecipeService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class RecipeController(val recipeService: RecipeService) {

    @RequestMapping("/recipe/show/{id}")
    fun showById(@PathVariable id : String, model : Model) : String {

        model.addAttribute("recipe", recipeService.findById(id.toLong()))

        return "recipe/show"
    }
}
