import java.util.function.Predicate
import java.util.stream.Collectors

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario (val name: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos: MutableList<Usuario> = mutableListOf()

    fun matricular(vararg usuario: Usuario) {

        for (user in usuario) {
            inscritos.add(user)
        }

    }

    override fun toString(): String {

        val nomeDosConteudos = conteudos.map { c -> c.nome }.toList()

        val estudantes = inscritos.map { u -> u.name }.toList()

        return "Formacao: {\n" +
                " Name: \"${nome}\",\n" +
                " Conteudos: {\n" +
                "   ${nomeDosConteudos}\n" +
                " }\n" +
                " Nivel: \"${nivel}\"\n" +
                " Inscritos: {\n" +
                "   ${estudantes}\n" +
                " }"

    }
}

fun main() {
    val formacaoKotlin = Formacao("Formacao em kotlin", listOf(ConteudoEducacional("Algoritmos"), ConteudoEducacional("POO Kotlin")), Nivel.BASICO)

    formacaoKotlin.matricular(Usuario("Eduardo"), Usuario("Cathiely"))

    println(formacaoKotlin.toString())
}