
enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario (val nome: String)
data class ConteudoEducacional(var nome: String, val duracao: Int = 120)
data class Formacao(val nome: String, val nivel: String, val conteudos: List<ConteudoEducacional>) {
    
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        print("${usuario.nome} matriculado com sucesso.")
    }
}

fun main() {
   
    var disciplinaKotlin = ConteudoEducacional("Kotlin", 210)
    var disciplinaAndroid = ConteudoEducacional("Android", 290)
    var conteudosEducacionais = mutableListOf(disciplinaKotlin, disciplinaAndroid)

    val selectNivel = Nivel.BASICO
    val nivel = when (selectNivel) {
        Nivel.BASICO -> "Básico"
        Nivel.INTERMEDIARIO -> "Intermediário"
        Nivel.AVANCADO -> "Avancado"
    }

    var formando = Formacao("Dev mobile", nivel, conteudosEducacionais )
    println(formando)

    val aluno = Usuario("Stephen")
    
    
   
    formando.matricular(aluno)
}
