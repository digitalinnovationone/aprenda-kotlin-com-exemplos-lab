
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if(!inscritos.contains(usuario)){
            inscritos.add(usuario)
            println("${usuario.nome} matriculado na $nome")
        }else{
            println("${usuario.nome} já está matriculado nesta formação")
        }
    }
    fun cancelarMatricula(usuario: Usuario){
        if(inscritos.contains(usuario)){
            inscritos.remove(usuario)
            println("${usuario.nome} teve sua matrícula cancelada na $nome")
        } else{
            println("${usuario.nome} não está matriculado nesta formação")
        }
    }
    fun usuarioEstaInscrito(usuario: Usuario): Boolean{
        return inscritos.contains(usuario)
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin")
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin")
    val formacao1 = Formacao ("Formação Kotlin", listOf(conteudo1, conteudo2), Nivel.INTERMEDIARIO)
    val usuario1 = Usuario ("João")
    val usuario2 = Usuario ("Maria")

    formacao1.matricular(usuario1)
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao1.cancelarMatricula(usuario1)
    println("Usuário 1 está inscrito na formação: ${formacao1.usuarioEstaInscrito(usuario1)}")
    println("Usuário 2 está inscrito na formação: ${formacao1.usuarioEstaInscrito(usuario2)}")
    }
