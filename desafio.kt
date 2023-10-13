// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(val nome: String) {
    val conteudos = mutableListOf<ConteudoEducacional>()
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} foi matriculado na formação $nome.")
    }
}

fun main() {
    // Criação de usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    val usuario3 = Usuario("Charlie")

    // Criação de conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 120)
    val conteudo2 = ConteudoEducacional("Banco de Dados", 90)

    // Criação de uma formação
    val formacao1 = Formacao("Desenvolvimento de Software")
    formacao1.conteudos.add(conteudo1)
    formacao1.conteudos.add(conteudo2)

    // Matricular usuários na formação
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao1.matricular(usuario3)

    // Exibir lista de inscritos
    println("Inscritos na formação ${formacao1.nome}: ${formacao1.inscritos.joinToString { it.nome }}")
}

