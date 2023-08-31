class Usuario (val nome: String)

enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    DIFICIL
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome")
    }
}

fun main() {
    val usuario = Usuario("teste")
    val conteudoAndroid = listOf(
        ConteudoEducacional("Conhecendo o Kotlin", 1),
        ConteudoEducacional("Introdução a prática à linguagem Kotlin", 2),
        ConteudoEducacional("Estruturas de controle", 2),
        ConteudoEducacional("Orientação a Objetos", 2),
    )
    val formacaoAndroid = Formacao("fundamentos android", Nivel.BASICO, conteudoAndroid)
    formacaoAndroid.matricular(usuario)
    println(formacaoAndroid)
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
