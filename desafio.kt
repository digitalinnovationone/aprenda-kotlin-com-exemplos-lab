// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if(!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("O usuário ${usuario.nome} foi matriculado na formação $nome")
        } else {
            println("O ${usuario.nome} já está matriculado na formação $nome!")
        }
    }
}

fun main() {
    val usuario1 = Usuario("Tiago")
    val usuario2 = Usuario("Ana")

    val conteudo1 = ConteudoEducacional("Algoritmos em Kotlin")
    val conteudo2 = ConteudoEducacional("Orientação a objetos")

    val formacaoAndroid = Formacao("Desenvolvimento Android", listOf(conteudo1, conteudo2))

    formacaoAndroid.matricular(usuario1)
    formacaoAndroid.matricular(usuario1)
    formacaoAndroid.matricular(usuario2)

    println("Inscritos na formação: ${formacaoAndroid.nome}: ${formacaoAndroid.inscritos.map { it.nome }}")
}
