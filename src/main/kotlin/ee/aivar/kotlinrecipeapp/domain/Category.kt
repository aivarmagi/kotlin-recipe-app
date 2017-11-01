package ee.aivar.kotlinrecipeapp.domain

import javax.persistence.*

@Entity
open class Category : BaseEntity() {

    var description: String? = null

    @ManyToMany(mappedBy = "categories")
    var recipes: Set<Recipe> = HashSet()

}
