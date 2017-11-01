package ee.aivar.kotlinrecipeapp.repository

import ee.aivar.kotlinrecipeapp.domain.Category
import org.springframework.data.repository.CrudRepository
import java.util.*

interface CategoryRepository : CrudRepository<Category, Long> {

    fun findByDescription(description: String): Optional<Category>
}
