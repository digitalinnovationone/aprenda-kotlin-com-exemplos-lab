enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 60)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 90)

    val formacao = Formacao("Desenvolvimento Android", listOf(conteudo1, conteudo2))

    val usuario1 = Usuario()
    val usuario2 = Usuario()

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    println("Inscritos na formação ${formacao.nome}: ${formacao.inscritos.size} usuários.")
}

