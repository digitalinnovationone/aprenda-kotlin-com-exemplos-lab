// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val nivel: Nivel)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        this.inscritos.add(usuario)
    }
}

fun main() {

    val usuario1 = Usuario("João", Nivel.BASICO)
    val usuario2 = Usuario("Maria", Nivel.INTERMEDIARIO)
    val usuario3 = Usuario("Pedro", Nivel.DIFICIL)

    val formacao1 = Formacao("Formação de Programadores", listOf(
        ConteudoEducacional("Lógica de Programação", 240),
        ConteudoEducacional("Algoritmos", 180),
        ConteudoEducacional("Programação Orientada a Objetos", 240)
    ))

    // Matricula o usuário 1 na formação 1
    formacao1.matricular(usuario1)

    // Matricula o usuário 2 na formação 1
    formacao1.matricular(usuario2)

    // Matricula o usuário 3 na formação 1
    formacao1.matricular(usuario3)

    println("Usuários matriculados na formação 1:")
    formacao1.inscritos.forEach { println(it.nome) }
}

