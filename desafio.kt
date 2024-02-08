import kotlin.random.Random

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val id: Int = Random.nextInt(), val name: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    private val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        usuario.forEach {
            inscritos.add(it)
            println("${it.name}(${it.id}) foi cadastrado com sucesso no curso $nome")
        }
    }

    fun mostrarTotalMatriculas() {
        println("Há um total de ${inscritos.size} de matriculas na formação $nome")
    }
}

fun main() {
    val kotlinFormacao = createKotlinFormacao()
    val luaFormacao = createLuaFormacao()

    kotlinFormacao.matricular(Usuario(name = "Fulano"))
    luaFormacao.matricular(
        Usuario(name = "Carlos"),
        Usuario(name = "Maria"),
        Usuario(name = "João"),
        Usuario(name = "Aline")
    )
    println("---------------------------")
    kotlinFormacao.mostrarTotalMatriculas()
    luaFormacao.mostrarTotalMatriculas()
}

fun createKotlinFormacao() = Formacao(
    "Formação em Kotlin",
    Nivel.BASICO,
    listOf(
        ConteudoEducacional("Aprendendo Kotlin na prática", 13),
        ConteudoEducacional("Kotlin no backend com Spring 3", 9),
    )
)

fun createLuaFormacao() = Formacao(
    "Formação Lua Developer",
    Nivel.INTERMEDIARIO,
    listOf(
        ConteudoEducacional("Primeiros passos com a linguagem Lua", 6),
        ConteudoEducacional("Avançando na linguagem Lua", 10),
        ConteudoEducacional("Além da Lua", 9),
    )
)
