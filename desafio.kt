enum class Nivel { NIVEL1, NIVEL2, NIVEL3 }

class Usuario

data class Conteudo(var nome: String, var duracao: Int = 90)

data class Formacao(var nome: String, var conteudos: List<Conteudo>) {

    val inscritos = mutableListOf<Usuario>()        
    val Inscritosdois: List<Usuario> = inscritos 
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)       
                                     }
    
    fun matriculados(): List<Usuario> {                                  
    return Inscritosdois
                                       }
    
                                                                                }

fun main() {
    val nivel = Nivel.NIVEL2  
    
    val messagem = when (nivel) {                      
        Nivel.NIVEL1 -> "Nível 1"
        Nivel.NIVEL2 -> "Nível 2"
        Nivel.NIVEL3 -> "Nível 3"
                                }
    println(messagem)

    val Conteudo = Conteudo("Kotlin", 90)
    println(Conteudo)
    
    val formacao = Formacao("", List("Kotlin", 90))
    
    matricular("Xavier")                                              
    println("Alunos matriculados: ${inscritos().size}")              
    
   
}
