// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario (val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, var duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String) {

    private val inscritos = mutableListOf<Usuario>()
    private val conteudos = mutableListOf<ConteudoEducacional>()
    
    fun matricular(usuario: Usuario) {
        TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
    }

    fun listarInscritos(){
        println("Inscritos na formação ${nome}")
        for (inscrito in inscritos){
            println("${inscrito.nome}")
        }
    }
    fun adicionarConteudo(conteudo: ConteudoEducacional){
        conteudos.add(conteudo)
    }

    fun listarConteudo(){
        println("Conteudos da formação ${nome}")
        for (conteudo in conteudos){
            println("${conteudo.nome}")
        }
    }
}

fun main() {
    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    val usuario1 = Usuario("Udimile", "udimile@gmail.com")
    val usuario2 = Usuario("Calaro", "Calaro@gmail.com")

    val conteudo1 = ConteudoEducacional("Conhecendo o Kotlin e Sua Documetação Oficial", 60, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin", 120, Nivel.BASICO)
    val conteudo3 = ConteudoEducacional("Estruturas de Controle de Fluxo e Coleções em Kotlin", 120, Nivel.BASICO)
    val conteudo4 = ConteudoEducacional("Orientação a Objetos e Tipos de Classes na Pratica com Kotlin", 120, Nivel.BASICO)
    val conteudo5 = ConteudoEducacional("Tratamento de Exceções em Kotlin", 120, Nivel.INTERMEDIARIO)


    formacao.adicionarConteudo(conteudo1)
    formacao.adicionarConteudo(conteudo2)
    formacao.adicionarConteudo(conteudo3)
    formacao.adicionarConteudo(conteudo4)
    formacao.adicionarConteudo(conteudo5)


    formacao.listarConteudos()

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    formacao.listarInscritos()
}
