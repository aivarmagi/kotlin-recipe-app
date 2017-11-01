package ee.aivar.kotlinrecipeapp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinRecipeAppApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinRecipeAppApplication::class.java, *args)
}
