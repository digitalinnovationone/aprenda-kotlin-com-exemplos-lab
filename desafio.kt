// [Template no Kotlin Playground](https://pl.kotl.in/hBCOTeMcA)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }
data class Usuario(val nome: String, val cpf: String)
data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, val nivel: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuarios: List<Usuario>) {
        inscritos.addAll(usuarios)
        println("matriculas efetuadas com sucesso.")
    }
}

fun main() {
    var disciplinaBasica1 = ConteudoEducacional("Lógica de Programação", 120)
    var disciplinaBasica2 = ConteudoEducacional("Programação orientada a objetos", 240)
    var disciplinaJava = ConteudoEducacional("Programação Java", 240)
    var disciplinaKotlin = ConteudoEducacional("Programação Java", 240)
    var ementaJava = mutableListOf(disciplinaBasica1, disciplinaBasica2, disciplinaJava)
    var ementaKotlin = mutableListOf(disciplinaBasica1, disciplinaBasica2, disciplinaKotlin)

    val selectNivel = Nivel.INTERMEDIARIO
    val nivel = when (selectNivel) {
        Nivel.BASICO -> "Básico"
        Nivel.INTERMEDIARIO -> "Intermediário"
        Nivel.AVANCADO -> "Avancado"
    }

    var formacaoJava = Formacao("FORMAÇÃO JAVA", nivel, ementaJava )
    var formacaoKotlin = Formacao("FORMAÇÃO KOTLIN", nivel, ementaKotlin )
    println("${formacaoJava.nome}, Nivel:${formacaoJava.nivel}")
    println("${formacaoKotlin.nome}, Nivel:${formacaoKotlin.nivel}")
    println("")

    val aluno1 = Usuario("Aluno1", "111.111.111-11")
    val aluno2 = Usuario("Aluno2", "222.222.222-22")
    val aluno3 = Usuario("Aluno3", "333.333.333-33")
    
    var alunosJava = mutableListOf(aluno1, aluno2)
    var alunosKotlin = mutableListOf(aluno3)
    
    formacaoJava.matricular(alunosJava)
    formacaoKotlin.matricular(alunosKotlin)
    
    println("Alunos matriculados formação Java")
    formacaoJava.inscritos.forEach {
        println("Aluno: ${it.nome} CPF: ${it.cpf}")
    }
    
    println("")
    
    println("Alunos matriculados formação Kotlin")
    formacaoKotlin.inscritos.forEach {
        println("Aluno: ${it.nome} CPF: ${it.cpf}")
    }
}
