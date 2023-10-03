import java.lang.IllegalArgumentException

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario (val nome: String, val idade: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if ( usuario.idade < 18 ){
            throw IllegalArgumentException ("$nome não pode se matricular, pois a formação é apenas para maiores de idade")
        }
            inscritos.add(usuario)
            println("Aluno ${usuario.nome} matriculado com sucesso na formação $nome (Conteúdo: ${conteudos.joinToString { it.nome }})")
    }
}

fun main() {
    val primeiroUsuario = Usuario("Eduardo", 32)
    val segundoUsuario = Usuario("João", 15)
    val primeiroConteudo = ConteudoEducacional("kotlin")
    val segundoConteudo = ConteudoEducacional("Java")
    val formacao = Formacao("TI", listOf(primeiroConteudo,segundoConteudo))
    formacao.matricular(primeiroUsuario)
    formacao.matricular(segundoUsuario)
}
