import java.util.Scanner
// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
val scanner = Scanner(System.`in`)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(name: String, email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val dificuldade: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun matricularAluno() {
    println("Nome do aluno: ")
    name = scanne.nextLine()
    println("Email do aluno: ")
    email = scanne.nextLine()
    val user: Usuario = Usuario(name, email)
    kotlinExperience.matricular(user)
    println("O aluno $name foi matriculado com sucesso!")
}

fun main() {
    val content: ConteudoEducacional = ("Conhecendo o Kotlin e Sua Documentação Oficial", 1, Nivel.BASICO)
    val ContentList = arrayListOf<ConteudoEducacional>(content)
    val user1: Usuario = Usuario("João", "joao@teste.com")
    val user2: Usuario = Usuario("Maria", "maria@teste.com")
    val kotlinExperience: Formacao = Formacao("Dominando a linguagem de programação Kotlin", contentList)
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    matricularAluno()
}