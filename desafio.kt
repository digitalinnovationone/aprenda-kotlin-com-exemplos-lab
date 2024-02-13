enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario) 
    }
}

fun main() {

    val kotlinSintaxe = ConteudoEducacional("Kotlin Sintaxe", 120, Nivel.BASICO)
    val kotlinMobile = ConteudoEducacional("Kotlin no Mobile", 1000, Nivel.AVANCADO)

    val kotlin = Formacao("Kotlin", conteudosKotlin)

    val joao = Usuario("João Fernando")

    kotlin.matricular(joao)

    println(kotlin)
}