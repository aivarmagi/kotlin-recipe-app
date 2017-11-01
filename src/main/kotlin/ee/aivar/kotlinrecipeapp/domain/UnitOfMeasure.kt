package ee.aivar.kotlinrecipeapp.domain

import javax.persistence.Entity

@Entity
open class UnitOfMeasure : BaseEntity() {

    var description: String? = null
}
