// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.toString()} matriculado na formação $nome.")
    } 
}

fun main() {
    // Exemplo de uso
    val conteudos = listOf(
        ConteudoEducacional("Introdução à Programação", 120),
        ConteudoEducacional("Estruturas de Dados", 180),
        ConteudoEducacional("Algoritmos Avançados", 240)
    )

    val formacao = Formacao("Ciência da Computação", conteudos)

    val usuario1 = Usuario()
    val usuario2 = Usuario()

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    println("Inscritos na formação ${formacao.nome}: ${formacao.inscritos}")
}

