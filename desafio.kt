package com.kotlin.dio.linguagem

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
//        TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
    }
}

fun main() {

//    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")

    val aluno1 = Usuario("João", "joao@example.com")
    val aluno2 = Usuario("Maria", "maria@example.com")

    val listaConteudos = listOf(
        ConteudoEducacional("Kotlin Básico", 120),
        ConteudoEducacional("Kotlin Intermediário", 180),
        ConteudoEducacional("Kotlin Avançado", 240)
    )

    val formacaoKotlin = Formacao("Formação Kotlin", listaConteudos, Nivel.INTERMEDIARIO)
    formacaoKotlin.matricular(aluno1)
    formacaoKotlin.matricular(aluno2)

//    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    println("Alunos matriculados na ${formacaoKotlin.nome}:")
    formacaoKotlin.inscritos.forEach { aluno ->
        println("- ${aluno.nome} (${aluno.email})")
    }
}

