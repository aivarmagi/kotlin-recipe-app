package ee.aivar.kotlinrecipeapp.domain

import javax.persistence.*

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

    @ManyToMany
    @JoinTable(name = "recipe_category",
        joinColumns = arrayOf(JoinColumn(name = "recipe_id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "category_id")))
    var categories: Set<Category> = HashSet()
}
