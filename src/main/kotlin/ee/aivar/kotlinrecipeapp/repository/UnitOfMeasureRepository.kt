package ee.aivar.kotlinrecipeapp.repository

import ee.aivar.kotlinrecipeapp.domain.UnitOfMeasure
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UnitOfMeasureRepository : CrudRepository<UnitOfMeasure, Long> {

    fun findByDescription(description: String): Optional<UnitOfMeasure>
}
