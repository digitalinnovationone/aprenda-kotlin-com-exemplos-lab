// Domínio DIO - Formações, Matrículas e Certificados

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

// Usuário com informações mínimas
data class Usuario(
    val nome: String,
    val email: String
)

// Conteúdo educacional
data class ConteudoEducacional(
    val nome: String,
    val duracao: Int = 30 // em minutos (padrão mais curto)
)

// Formação com nível, vagas e controle de matrícula
data class Formacao(
    val nome: String,
    val nivel: Nivel,
    val conteudos: List<ConteudoEducacional>,
    val vagas: Int,
    var matriculasAbertas: Boolean = true
) {

    val inscritos = mutableListOf<Usuario>()
    private val certificadosEmitidos = mutableSetOf<Usuario>()

    fun abrirMatriculas() {
        matriculasAbertas = true
        println("🔓 Matrículas abertas para \"$nome\".")
    }

    fun fecharMatriculas() {
        matriculasAbertas = false
        println("🔒 Matrículas fechadas para \"$nome\".")
    }

    fun matricular(usuario: Usuario) {
        if (!matriculasAbertas) {
            println("⛔ Matrículas fechadas para \"$nome\". ${usuario.nome} não pode se inscrever.")
            return
        }

        if (inscritos.contains(usuario)) {
            println("⚠️ Usuário ${usuario.nome} já está matriculado em \"$nome\".")
            return
        }

        if (inscritos.size >= vagas) {
            println("❌ Não há vagas disponíveis em \"$nome\" para ${usuario.nome}.")
            return
        }

        inscritos.add(usuario)
        println("✅ ${usuario.nome} foi matriculado com sucesso em \"$nome\".")
    }

    fun cargaHorariaTotal(): Int =
        conteudos.sumOf { it.duracao }

    fun emitirCertificado(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            println("❌ Não é possível emitir certificado: ${usuario.nome} não está matriculado em \"$nome\".")
            return
        }

        if (!certificadosEmitidos.add(usuario)) {
            println("⚠️ Certificado de ${usuario.nome} já havia sido emitido para \"$nome\".")
            return
        }

        println("🎓 Certificado emitido para ${usuario.nome} na formação \"$nome\". Parabéns!")
    }

    fun resumo(): String = buildString {
        appendLine("Formação: $nome")
        appendLine("Nível: $nivel")
        appendLine("Quantidade de módulos: ${conteudos.size}")
        appendLine("Carga horária total: ${cargaHorariaTotal()} minutos")
        appendLine("Vagas: $vagas | Inscritos: ${inscritos.size}")
        appendLine("Matrículas abertas: $matriculasAbertas")
    }
}

fun main() {
    // 1) Conteúdos educacionais (1/3 do tempo original)
    // Originais: 90, 120, 110, 100
    val c1 = ConteudoEducacional("Introdução ao Kotlin", 30)   // 90 / 3
    val c2 = ConteudoEducacional("Orientação a Objetos com Kotlin", 40) // 120 / 3
    val c3 = ConteudoEducacional("Collections e Funções de Alta Ordem", 37) // ~110 / 3
    val c4 = ConteudoEducacional("Coroutines e Concorrência", 33) // ~100 / 3

    // 2) Formação
    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin Developer - DIO",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(c1, c2, c3, c4),
        vagas = 2,
        matriculasAbertas = true
    )

    // 3) Usuários
    val u1 = Usuario("Ramon", "ramon@example.com")
    val u2 = Usuario("Ana", "ana@example.com")
    val u3 = Usuario("Bruno", "bruno@example.com")

    // 4) Resumo da formação
    println("=== RESUMO DA FORMAÇÃO ===")
    println(formacaoKotlin.resumo())

    println("\n=== CONTEÚDOS DA FORMAÇÃO ===")
    formacaoKotlin.conteudos.forEachIndexed { index, conteudo ->
        println("${index + 1}. ${conteudo.nome} - ${conteudo.duracao} min")
    }

    // 5) Matrículas
    println("\n=== MATRÍCULAS (MATRÍCULAS ABERTAS) ===")
    formacaoKotlin.matricular(u1)
    formacaoKotlin.matricular(u2)

    formacaoKotlin.fecharMatriculas()
    formacaoKotlin.matricular(u3)

    formacaoKotlin.abrirMatriculas()
    formacaoKotlin.matricular(u3)

    formacaoKotlin.matricular(u1)

    // 6) Certificados
    println("\n=== CERTIFICADOS ===")
    formacaoKotlin.emitirCertificado(u1)
    formacaoKotlin.emitirCertificado(u1)
    formacaoKotlin.emitirCertificado(u3)

    // 7) Inscritos
    println("\n=== ALUNOS MATRICULADOS ===")
    formacaoKotlin.inscritos.forEach { usuario ->
        println("- ${usuario.nome} (${usuario.email})")
    }
}

