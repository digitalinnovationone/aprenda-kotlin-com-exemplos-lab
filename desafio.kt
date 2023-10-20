enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario (val matricula: String, val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 68)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }
}

fun main() {
    val aluno = Usuario("10101","Sthefane", "facilprogramacao@gmail.com")

    val curso1 = ConteudoEducacional("Desmitificando Kotlin para Programadores Java")
    val curso2 = ConteudoEducacional("Explorando Padrões de Projetos Na Prática com Kotlin")

    val cursos: List<ConteudoEducacional> = listOf(curso1, curso2)

    val formacao = Formacao("Code Update TQI - Backend com Kotlin e Java", Nivel.INTERMEDIARIO, cursos)

    formacao.matricular(aluno)
    println(formacao)
}
