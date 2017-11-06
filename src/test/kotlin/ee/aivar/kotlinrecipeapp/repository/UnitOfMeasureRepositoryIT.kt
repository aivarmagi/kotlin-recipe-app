package ee.aivar.kotlinrecipeapp.repository

import ee.aivar.kotlinrecipeapp.domain.UnitOfMeasure
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@RunWith(SpringRunner::class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    lateinit var unitOfMeasureRepository : UnitOfMeasureRepository

    @Test
    fun `should find teaspoon by description`() {
        val uomOptional : Optional<UnitOfMeasure> = unitOfMeasureRepository.findByDescription("Teaspoon")

        assertEquals("Teaspoon", uomOptional.get().description)
    }

    @Test
    fun `should find cup by description`() {
        val uomOptional : Optional<UnitOfMeasure> = unitOfMeasureRepository.findByDescription("Cup")

        assertEquals("Cup", uomOptional.get().description)
    }
}
