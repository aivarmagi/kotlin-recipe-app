package ee.aivar.kotlinrecipeapp.domain

import javax.persistence.*
import kotlin.jvm.Transient

@Entity
class Recipe : BaseEntity() {

    var description: String? = null
    var prepTime: Int? = null
    var cookTime: Int? = null
    var servings: Int? = null
    var source: String? = null
    var url: String? = null

    @Lob
    var directions: String? = null

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "recipe")
    var ingredients: Set<Ingredient> = HashSet()

    @Lob
    var image: ByteArray? = null

    @Enumerated(value = EnumType.STRING)
    var difficulty: Difficulty? = null

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    var notes: Notes? = null
        //override default setter to set recipe/notes bidirectional relation
        set(value)  {
            field = value
            field?.recipe = this
        }

    @ManyToMany
    @JoinTable(name = "recipe_category",
        joinColumns = arrayOf(JoinColumn(name = "recipe_id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "category_id")))
    var categories: Set<Category> = HashSet()
}
