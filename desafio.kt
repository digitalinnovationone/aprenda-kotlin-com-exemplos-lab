// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val id: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

val conteudo1 = ConteudoEducacional("Kotlin", 60, Nivel.INTERMEDIARIO)
val conteudo2 = ConteudoEducacional("Android", 50, Nivel.INTERMEDIARIO)
val conteudo3 = ConteudoEducacional("Git", 10, Nivel.BASICO)
val conteudo4 = ConteudoEducacional("Java", 60, Nivel.DIFICIL)

val formacaoAndroidKotlin = Formacao("ANDROIDKT", listOf(conteudo1, conteudo2, conteudo3))
val formacaoAndroidJava = Formacao("ANDROIDJV", listOf(conteudo4, conteudo2, conteudo3))

val usuario1 = Usuario(1)
val usuario2 = Usuario(2)
val usuario3 = Usuario(3)
val usuario4 = Usuario(4)

fun main() {
    formacaoAndroidKotlin.matricular(usuario1)
    formacaoAndroidKotlin.matricular(usuario3)
    formacaoAndroidKotlin.matricular(usuario4)
    formacaoAndroidKotlin.matricular(usuario2)
}