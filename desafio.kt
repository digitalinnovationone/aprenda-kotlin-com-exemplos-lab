// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)



enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val id: Int, val nome: String)

data class ConteudoEducacional(
    var nome: String,
    val duracaoMinutos: Int = 60
)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: List<ConteudoEducacional>
) {
    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        // Evitar duplicidade de matrícula
        if (inscritos.any { it.id == usuario.id }) {
            println("⚠️ Usuário '${usuario.nome}' já está matriculado na formação '$nome'.")
            return
        }
        inscritos.add(usuario)
        println("✅ Usuário '${usuario.nome}' matriculado com sucesso na formação '$nome'.")
    }

    fun listarInscritos(): List<Usuario> = inscritos.toList()

    fun cargaHorariaTotal(): Int = conteudos.sumOf { it.duracaoMinutos }

    fun descricao(): String = buildString {
        appendLine("Formação: $nome")
        appendLine("Nível: $nivel")
        appendLine("Conteúdos (${conteudos.size}):")
        conteudos.forEachIndexed { idx, c ->
            appendLine("  ${idx + 1}. ${c.nome} - ${c.duracaoMinutos} min")
        }
        appendLine("Carga horária total: ${cargaHorariaTotal()} min")
        appendLine("Inscritos: ${inscritos.size}")
    }
}

fun main() {
    // Usuários
    val u1 = Usuario(1, "Ana")
    val u2 = Usuario(2, "Bruno")
    val u3 = Usuario(3, "Carla")

    // Conteúdos
    val c1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val c2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", 120)
    val c3 = ConteudoEducacional("Coleções e Funções de Alta Ordem", 80)
    val c4 = ConteudoEducacional("Corrotinas e Concorrência", 100)

    // Formação: Kotlin Developer
    val formacaoKotlin = Formacao(
        nome = "Kotlin Developer",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(c1, c2, c3, c4)
    )

    // Cenário de matrícula
    println(formacaoKotlin.descricao())
    formacaoKotlin.matricular(u1)
    formacaoKotlin.matricular(u2)
    formacaoKotlin.matricular(u2) // tentar matricular de novo (deve avisar)
    formacaoKotlin.matricular(u3)

    println("\nInscritos na formação '${formacaoKotlin.nome}':")
    formacaoKotlin.listarInscritos().forEach { println(" - ${it.nome} (id=${it.id})") }

    println("\nCarga horária total: ${formacaoKotlin.cargaHorariaTotal()} min")
}
