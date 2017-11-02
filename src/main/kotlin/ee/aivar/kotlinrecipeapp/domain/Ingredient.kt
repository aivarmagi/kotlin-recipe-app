package ee.aivar.kotlinrecipeapp.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
class Ingredient : BaseEntity() {

    var description: String? = null
    var amount: BigDecimal? = null

    @ManyToOne
    var recipe: Recipe? = null

    @OneToOne(fetch = FetchType.EAGER)
    var uom: UnitOfMeasure? = null
}
