package ee.aivar.kotlinrecipeapp.domain

import javax.persistence.*

@Entity
class Category (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,
    val description: String,

    @ManyToMany(mappedBy = "categories")
    val recipes: Set<Recipe>

)