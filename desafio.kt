import java.util.Scanner
import kotlin.jvm.internal.Intrinsics.Kotlin

enum class Nivel {
    BASICO, INTERMEDIARIO, DIFICIL
}
class Usuario(var nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int ){
    fun getInfo(): String{
        return "O conteudo educacional escolhido é $nome e tem duração de $duracao horas!"
    }
}

data class Formacao(val nome: String,val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()



    fun matricular(usuario: Usuario): String {
        inscritos.add(usuario)
        val duracaoTotal = conteudos.sumBy { it.duracao }
        return "O(A) ${usuario.nome} está matriculado na $nome que tem duração de $duracaoTotal horas"
    }
    fun getInfo(): String{

        return "A $nome possui os cursos $nivel de ${conteudos[0].nome} e ${conteudos[1].nome}"
    }

    fun getInscritos(): String {
        return "Usuários inscritos: ${inscritos.joinToString(", ") { it.nome }}"
    }
}

fun main() {
    val scan = Scanner(System.`in`)
    val javaIntro = ConteudoEducacional(nome = "Introdução a Java", duracao = 10)
    val kotlinIntro = ConteudoEducacional(nome = "Introdução a Kotlin", duracao = 10)
    val javaInter = ConteudoEducacional(nome = "Java Intermediário", duracao = 50)
    val kotlinInter= ConteudoEducacional(nome = "Kotlin Intermediário", duracao = 50)
    val javaAvan = ConteudoEducacional(nome = "Java avançado", duracao = 100)
    val kotlinAvan = ConteudoEducacional(nome = "Kotlin Avançado", duracao = 10,)

    val listaConteudoIntro: List<ConteudoEducacional> = listOf(javaIntro, kotlinIntro)
    val listaConteudoInter: List<ConteudoEducacional> = listOf(javaInter, kotlinInter)
    val listaConteudoAvan: List<ConteudoEducacional> = listOf(javaAvan, kotlinAvan)

    val introdutorio = Formacao("Turma Introdutória",nivel = Nivel.BASICO, listaConteudoIntro)
    val intermediario = Formacao("Turma Intermediária", Nivel.INTERMEDIARIO, listaConteudoInter)
    val avancado = Formacao("Turma Avançada", Nivel.DIFICIL, listaConteudoAvan)








    var selecao: Boolean=true;

      loopPrincipal@  while(selecao){
             scan.nextLine()
            println("Digite seu nome")
            var nome: String = scan.nextLine()
            val usuario = Usuario(nome)

            println("Olá, $nome\nEscolha formação de preferência\n1- Introdutório\n2- Intermediário\n3- Avançado \n4- Sair")
            val opcao: Int = scan.nextInt()
            when(opcao){
                1 -> {

                    println(introdutorio.getInfo())
                    println("Deseja se matricular? \n1- Sim \n2- Não")
                    val matricula: Int = scan.nextInt()
                    if(matricula == 1){
                        println(introdutorio.matricular(usuario))
                        println(introdutorio.getInscritos())
                        println("Deseja matricular outra pessoa? \n" +
                                "1- Sim \n" +
                                "2- Não")
                        val outraOpcao: Int = scan.nextInt()
                        if(outraOpcao == 1){
                            continue@loopPrincipal
                        } else if (outraOpcao == 2){
                            println("Finalizando programa...")
                            scan.close()
                            System.exit(0)
                        }

                }
                
            }
            2 -> {
                println(intermediario.getInfo())
                println("Deseja se matricular? \n1- Sim \n2- Não")
                val matricula: Int = scan.nextInt()
                if(matricula == 1) {
                    println(intermediario.matricular(usuario))
                    println(intermediario.getInscritos())
                    println(
                        "Deseja matricular outra pessoa? \n" +
                                "1- Sim \n" +
                                "2- Não"
                    )
                    val outraOpcao: Int = scan.nextInt()
                    if (outraOpcao == 1) {
                        continue@loopPrincipal
                    } else if (outraOpcao == 2) {
                        println("Finalizando programa...")
                        scan.close()
                        System.exit(0)
                    }
                }

            }
            3 ->{
                    println(avancado.getInfo())
                    println("Deseja se matricular? \n1- Sim \n2- Não")
                    val matricula: Int = scan.nextInt()
                    if(matricula == 1) {
                        println(avancado.matricular(usuario))
                        println(avancado.getInscritos())
                        println(
                            "Deseja matricular outra pessoa? \n" +
                                    "1- Sim \n" +
                                    "2- Não"
                        )
                        val outraOpcao: Int = scan.nextInt()
                        if (outraOpcao == 1) {
                            continue@loopPrincipal
                        } else if (outraOpcao == 2) {
                            println("Finalizando programa...")
                            scan.close()
                            System.exit(0)
                        }
                    }
            }
            4 -> {
                println("Saindo do programa...")
                selecao = false
                scan.close()
                System.exit(0)
            };
            else ->println("Opção ínvalida")
        }
    }




}
