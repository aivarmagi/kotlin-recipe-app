package ee.aivar.kotlinrecipeapp.controller

import ee.aivar.kotlinrecipeapp.domain.Category
import ee.aivar.kotlinrecipeapp.domain.UnitOfMeasure
import ee.aivar.kotlinrecipeapp.repository.CategoryRepository
import ee.aivar.kotlinrecipeapp.repository.UnitOfMeasureRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@Controller
class IndexController (val categoryRepository: CategoryRepository,
                       val unitOfMeasureRepository: UnitOfMeasureRepository) {

    @RequestMapping("", "/", "/index")
    fun getIndexPage() : String {
        val categoryOptional: Optional<Category> = categoryRepository.findByDescription("American")
        val unitOfMeasureOptional: Optional<UnitOfMeasure> = unitOfMeasureRepository.findByDescription("Teaspoon")

        System.out.println("Cat id is: " + categoryOptional.get())
        System.out.println("Uom id is: " + unitOfMeasureOptional.get())

        return "index"
    }
}
