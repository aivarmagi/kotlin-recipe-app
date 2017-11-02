package ee.aivar.kotlinrecipeapp.domain

import javax.persistence.Entity

@Entity
class UnitOfMeasure : BaseEntity() {

    var description: String? = null
}
