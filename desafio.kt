enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val id: Long)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} matriculado com sucesso!")
    }
}

fun main() {
    //criando conteúdos
    val listaDeConteudosAndroid: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Funções em Kotlin", 120),
        ConteudoEducacional("Introdução a Orientação a Objetos com Kotlin ", 60),
        ConteudoEducacional("Corrotinas com Kotlin", 90)
    )

    //criando os usuários
    val aluno1 = Usuario("Bruno", 10)
    val aluno2 = Usuario("Maggie", 20)
    val aluno3 = Usuario("Rejane", 30)

    val formacao = Formacao("Android Developer", listaDeConteudosAndroid, Nivel.INTERMEDIARIO)
    formacao.matricular(aluno1)
    formacao.matricular(aluno2)
    formacao.matricular(aluno3)

    println("Inscritos na formação ${formacao.nome}: ${formacao.inscritos.map { it.nome }}. Nível: ${Nivel.INTERMEDIARIO}. Conteúdos abordados: ${formacao.conteudos.map { it.nome}}.")


}