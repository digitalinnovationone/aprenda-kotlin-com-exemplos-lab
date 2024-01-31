fun main() {
    program()
}

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }
class Usuario (val nome: String, val idade: Int)
data class ConteudoEducacional(val nome: String, val creditos: Int)
data class Formacao(val nome: String, val nivel: Nivel,  var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}
fun program(){

    // Definindo quais disciplinas irão fazer parte do curso.
    val listaDeDisciplinas = listOf(
            ConteudoEducacional("Introdução à programação em C", 2,),
            ConteudoEducacional("Banco de Dados I", 3),
            ConteudoEducacional("Processos Estocáticos", 4)
    )

    // Criando o curso.
    var formacao = Formacao("Engenharia da Computação (Computação Aplicada)", Nivel.DIFICIL, listaDeDisciplinas)

    // Matriculando alguns alunos:
    formacao.matricular(Usuario("Thiago", 34))
    formacao.matricular(Usuario("Julia", 9))
    formacao.matricular(Usuario("Bruce Lee", 53))

    println("Nome da formação: " + formacao.nome)
    println("Nível de dificuldade: " + formacao.nivel)

    println("Disciplinas: ")
    for (materias in 0..formacao.conteudos.size-1)
        println(formacao.conteudos[materias].nome)

    println("Alunos Matriculados: ")
    for (alunos in 0..formacao.inscritos.size-1)
        println(formacao.inscritos[alunos].nome + ", " + formacao.inscritos[alunos].idade + " anos.")
}