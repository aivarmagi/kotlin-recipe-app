package ee.aivar.kotlinrecipeapp.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
class Ingredient (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = -1,

        val description: String,
        val amount: BigDecimal,

        @ManyToOne
        val recipe: Recipe,

        @OneToOne(fetch = FetchType.EAGER)
        val uom: UnitOfMeasure
)
