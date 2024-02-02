enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class MatriculaException(message: String) : Exception(message)
class ConteudoInexistenteException(message: String) : Exception(message)

data class Formacao(val nome: String, val conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario, conteudo: ConteudoEducacional) {
        if (!conteudos.contains(conteudo)) {
            throw ConteudoInexistenteException("Conteúdo '${conteudo.nome}' não existe na formação $nome")
        }

        inscritos.add(usuario)
        conteudos.add(conteudo)
        println("$usuario matriculado na formação $nome com o conteúdo ${conteudo.nome}")
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo '${conteudo.nome}' adicionado à formação $nome")
    }
}

fun main() {
    // Criando alguns objetos para simular cenários de teste
    val usuario1 = Usuario()
    val usuario2 = Usuario()

    val conteudo1 = ConteudoEducacional("Curso de Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)

    val formacao = Formacao("Formação em Programação")

    formacao.adicionarConteudo(conteudo1)
    formacao.adicionarConteudo(conteudo2)

    try {
        formacao.matricular(usuario1, conteudo1)
        formacao.matricular(usuario2, conteudo2)
    } catch (e: ConteudoInexistenteException) {
        println("Erro: ${e.message}")
    }
}
