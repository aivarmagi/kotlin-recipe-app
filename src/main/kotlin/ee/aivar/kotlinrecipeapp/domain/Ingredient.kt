package ee.aivar.kotlinrecipeapp.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
class Ingredient(
    var description: String?,
    var amount: BigDecimal?,

    @OneToOne(fetch = FetchType.EAGER)
    var uom: UnitOfMeasure?,

    @ManyToOne
    var recipe: Recipe?
) : BaseEntity()
