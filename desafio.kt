enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: String, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        print("${usuario.nome} matriculado com sucesso.")
    }
}

fun main() {
    var disciplinaKotlin = ConteudoEducacional("Kotlin", 98)
    var disciplinaAndroid = ConteudoEducacional("Android", 210)
    var conteudosEducacionais = mutableListOf(disciplinaKotlin, disciplinaAndroid)
    
    val selectNivel = Nivel.INTERMEDIARIO
    val nivel = when (selectNivel) {
        Nivel.BASICO -> "Básico"
        Nivel.INTERMEDIARIO -> "Intermediário"
        Nivel.DIFICIL -> "Difícil"
    }
    
    var formando = Formacao("Dev mobile", nivel, conteudosEducacionais )
    println(formando)
    
    val aluno = Usuario("James")
    formando.matricular(aluno)
}