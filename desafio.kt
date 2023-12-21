import java.util.Scanner
import kotlin.jvm.internal.Intrinsics.Kotlin

enum class Nivel {
    BASICO, INTERMEDIARIO, DIFICIL
}
class Usuario(var nome: String, var idade: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int ){
    fun getInfo(): String{
        return "O conteudo educacional escolhido é $nome e a duração é de $duracao dias!"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }
}

fun main() {
    val scan = Scanner(System.`in`)
    val java = ConteudoEducacional(nome = "Java", duracao = 40)
    val kotlin = ConteudoEducacional(nome = "Kotlin", duracao = 50)

    println("Digite seu nome")
    val nome: String = scan.nextLine()


    var selecao: Boolean=true;

    while(selecao){
        println("Olá, $nome\nDigite uma opção para iniciarmos\n1- Java\n2- Kotlin\n3- Sair")
        val opcao: Int = scan.nextInt()
        when(opcao){
            1 -> {
                println(java.getInfo())
                
            }
            2 -> println(kotlin.getInfo())
            3 -> {
                println("Saindo do programa...")
                selecao = false
            };
            else ->println("Opção ínvalida")
        }
    }




}
