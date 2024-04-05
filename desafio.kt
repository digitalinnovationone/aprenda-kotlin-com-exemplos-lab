// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(var nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, var nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuarios: Usuario) {
        inscritos.addAll(usuarios)
        for (usuario in usuarios) {
            println("${usuario.nome} matriculado em $nome com sucesso.")
        }
    }
}

fun main() {
    val cursoAngular = ConteudoEducacional("Curso Angular 8+", 120)
    val cursoSpring = ConteudoEducacional("Curso Spring Framework Completo", 240)
    val cursoIntroducaoKotlin = ConteudoEducacional("Curso Kotlin Iniciante", 30)
    val cursoJavaWeb = ConteudoEducacional("Curso Java Web", 120)
    val cursoJs = ConteudoEducacional("JavaScript", 20)
    val cursoAgile = ConteudoEducacional("Agile", 60)

    val formacaoAngular = Formacao("Angular", listOf(cursoAngular), Nivel.INTERMEDIARIO)
    val formacaoSpring = Formacao("Spring", listOf(cursoSpring), Nivel.INTERMEDIARIO)
    val formacaoKotlin = Formacao("Curso Kotlin Iniciante", listOf(cursoIntroducaoKotlin), Nivel.INTERMEDIARIO)
    val formacaoJavaWeb = Formacao("Java Web Fullstack", listOf(cursoJavaWeb), Nivel.INTERMEDIARIO)


    println(formacaoAngular)
    print("\n")
    println(formacaoSpring)
    print("\n")
    println(formacaoJavaWeb)
    print("\n")
    println(formacaoKotlin)
}
