package ee.aivar.kotlinrecipeapp.domain

import javax.persistence.*

@Entity
class Notes : BaseEntity() {

    @OneToOne
    var recipe: Recipe? = null

    @Lob
    var recipeNotes: String? = null
}
