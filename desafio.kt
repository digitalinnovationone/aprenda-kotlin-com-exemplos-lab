enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun calcularDuracaoTotal(): Int {
        return conteudos.sumOf { it.duracao }
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val usuario1 = Usuario()
    val usuario2 = Usuario()

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)

    val formacaoKotlin = Formacao("Formação Kotlin", mutableListOf(conteudo1, conteudo2), Nivel.INTERMEDIARIO)

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    println("Formação: ${formacaoKotlin.nome}")
    println("Nível: ${formacaoKotlin.nivel}")
    println("Conteúdos:")
    for (conteudo in formacaoKotlin.conteudos) {
        println("- ${conteudo.nome}, Duração: ${conteudo.duracao} minutos")
    }
    println("Tempo total da formação: ${formacaoKotlin.calcularDuracaoTotal()} minutos")
    println("Usuários matriculados na formação Kotlin: ${formacaoKotlin.inscritos.size}")
}
