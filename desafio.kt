import java.util.Scanner
import kotlin.jvm.internal.Intrinsics.Kotlin

enum class Nivel {
    BASICO, INTERMEDIARIO, DIFICIL
}
class Usuario(var nome: String, var idade: Int)

data class ConteudoEducacional(var nome: String,val nivel: Nivel, val duracao: Int ){
    fun getInfo(): String{
        return "O conteudo educacional escolhido é $nome $nivel e tem duração de $duracao dias!"
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
    val javaBasico = ConteudoEducacional(nome = "Java",nivel = Nivel.BASICO, duracao = 40)
    val javaInter = ConteudoEducacional(nome = "Java",nivel = Nivel.INTERMEDIARIO, duracao = 50)
    val javaDificil = ConteudoEducacional(nome = "Java",nivel = Nivel.DIFICIL, duracao = 60)
    val kotlinBasico = ConteudoEducacional(nome = "Kotlin",nivel =Nivel.BASICO, duracao = 50)
    val kotlinInter = ConteudoEducacional(nome = "Kotlin",nivel =Nivel.INTERMEDIARIO, duracao = 60)
    val kotlinDificil = ConteudoEducacional(nome = "Kotlin",nivel =Nivel.DIFICIL, duracao = 70)

    println("Digite seu nome")
    val nome: String = scan.nextLine()


    var selecao: Boolean=true;

    while(selecao){
        println("Olá, $nome\nEscolha a linguagem de preferência\n1- Java\n2- Kotlin\n3- Sair")
        val opcao: Int = scan.nextInt()
        when(opcao){
            1 -> {
                println("Escolha o nível \n1- Básico\n2- Intermediário \n3- Difícil")
                val opcaoNivel: Int = scan.nextInt()
                if(opcaoNivel == 1){
                    println(javaBasico.getInfo())
                } else if(opcaoNivel == 2){
                    println(javaInter.getInfo())
                } else if(opcaoNivel == 3){
                    println(javaDificil.getInfo())
                } else {
                    println("Opção ínvalida")
                }
                
            }
            2 -> {
                println("Escolha o nível \n1- Básico\n2- Intermediário \n3- Difícil")
                val opcaoNivel: Int = scan.nextInt()
            }
            3 -> {
                println("Saindo do programa...")
                selecao = false
            };
            else ->println("Opção ínvalida")
        }
    }




}
