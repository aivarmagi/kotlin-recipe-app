package ee.aivar.kotlinrecipeapp.controller

import ee.aivar.kotlinrecipeapp.service.RecipeService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController (val recipeService: RecipeService) {

    @RequestMapping("", "/", "/index")
    fun getIndexPage(model : Model) : String {

        model.addAttribute("recipes", recipeService.getRecipes())

        return "index"
    }
}
