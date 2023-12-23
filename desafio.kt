// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} teve sua matrícula realizada na formação ${this.nome}.")
    }
}

fun main() {
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 60)
    val conteudo2 = ConteudoEducacional("Kotlin Avançado", 120)

    val formacao = Formacao("Kotlin Completo", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
}
