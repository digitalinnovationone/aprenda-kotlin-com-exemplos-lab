enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario (val name: String)

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.addAll(usuario)

    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    val kotlin = listOf(
        ConteudoEducacional("introdução ao kotlin", 120),
        ConteudoEducacional("POO com Kotlin", 180),
        ConteudoEducacional("desafios kotlin", 60)
    )

    val java = listOf(
        ConteudoEducacional("introdução ao Java", 120),
        ConteudoEducacional("POO com Java", 180),
        ConteudoEducacional("desafios Java", 60)
    )

    val paulo = Usuario("Paulo")
    val felipe = Usuario("Felipe")
    val daniela = Usuario("Daniela")

    val formacaoKotlin = Formacao("Kotlin", kotlin, Nivel.INTERMEDIARIO)
    val formacaoJava = Formacao("Java", java, Nivel.BASICO)

    formacaoJava.matricular(paulo, felipe)
    formacaoKotlin.matricular(daniela, paulo)

    println("Alunos da trilha Java: ${formacaoJava.inscritos.joinToString { it.name }}")
    println("Alunos da trilha Kotlin: ${formacaoKotlin.inscritos.joinToString { it.name }}")
}
