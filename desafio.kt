// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        // TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
        println("${usuario.nome} foi matriculado na formação de $nome.")
    }

    fun listarInscritos() {
        println("Alunos matriculados na formação de $nome:")
        for (aluno in inscritos) {
            println(aluno.nome)
        }
    }
}

fun main() {
    // TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    // TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 60)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 90)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados", 120)

    val formacao1 = Formacao("Desenvolvimento Web", Nivel.BASICO, listOf(conteudo1))
    val formacao2 = Formacao("Ciência de Dados", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))
    val formacao3 = Formacao("Machine Learning", Nivel.DIFICIL, listOf(conteudo1, conteudo2, conteudo3))

    val aluno1 = Usuario("Alice")
    val aluno2 = Usuario("Bob")
    val aluno3 = Usuario("Carol")

    formacao1.matricular(aluno1)
    formacao1.matricular(aluno2)
    formacao2.matricular(aluno2)
    formacao2.matricular(aluno3)
    formacao3.matricular(aluno1)

    formacao1.listarInscritos()
    formacao2.listarInscritos()
    formacao3.listarInscritos()
}
