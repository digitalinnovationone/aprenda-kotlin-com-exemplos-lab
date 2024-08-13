// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String, val age: Int)
-
data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val author: String)

class Curso(val nome: String, val nivel: Nivel, var contents: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuario ${usuario.nome} added ti course $nome")
    }

    fun addContent(content: ConteudoEducacional) {
        contents.add(content)
        println("Content ${content.nome} added to course $nome")
    }

    fun removeContent(content: ConteudoEducacional) {
        if (contents.remove(content)) {
            println("Content ${content.nome} removed from course $nome")
        } else {
            println("Content ${content.nome} not found in course $nome")
        }
    }

    fun details() {
        println("Course: $nome")
        println("Level: $nivel") // Prints the name of the level (e.g., "INTERMEDIATE")
        println("Contents:")
        if (contents.isEmpty()) {
            println("   No content added yet.")
        } else {
            for (content in contents) {
                println(" - ${content.nome} (${content.duracao} minutes) - (by ${content.author})")
            }
        }

        println("Enrolled Students:")
        if (inscritos.isEmpty()) {
            println("   No students enrolled yet.")
        } else {
            for (inscrito in inscritos) {
                println(" - ${inscrito.nome} (${inscrito.email})")
            }
        }
    }
}

fun main() {
    val user1 = Usuario("Paul", "paul@gmail.com", 35)
    val user2 = Usuario("Cleber", "ckb@gmail.com", 21)

    val content1 = ConteudoEducacional("Introduction to Kotlin", 90, "Professor A")
    val content2 = ConteudoEducacional("Introduction to Java", 120, "Professor B") // Duration changed to 120 minutes

    val javaCourse = Curso("Java Course", Nivel.INTERMEDIARIO)
    javaCourse.addContent(content1) // Adding the correct contents
    javaCourse.addContent(content2)

    javaCourse.matricular(user1)
    javaCourse.matricular(user2)

    javaCourse.details()
}