// Enumeração para representar os níveis de formação
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

// Classe representando um usuário
class Usuario(val nome: String)

// Classe representando um conteúdo educacional
data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

// Classe representando uma formação
data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    // Método para matricular um usuário na formação
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    // Método para exibir detalhes da formação
    fun exibirDetalhes() {
        println("Formação: $nome")
        println("Nível: $nivel")
        println("Conteúdos:")
        conteudos.forEach { println("- ${it.nome} (${it.duracao} minutos)") }
        println("Inscritos: ${inscritos.size} usuários")
    }
}

fun main() {
    // Cenário de teste
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", 120)

    // Criando uma formação
    val formacaoKotlin = Formacao("Formação Kotlin", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))

    // Matriculando usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    // Exibindo detalhes da formação
    formacaoKotlin.exibirDetalhes()
}

