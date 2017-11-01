package ee.aivar.kotlinrecipeapp.domain

import javax.persistence.*

@Entity
open class Notes : BaseEntity() {

    @OneToOne
    var recipe: Recipe? = null

    @Lob
    var recipeNotes: String? = null
}
