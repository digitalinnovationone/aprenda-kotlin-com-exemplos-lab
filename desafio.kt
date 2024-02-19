enum class Nivel {BASICO, INTERMEDIARIO, AVANCADO}

data class Usuario (val id: Int,val nome: String, val username: String, val professor: Boolean)

data class ConteudoEducacional(val nome: String, val duracao: Int, val usuario: Usuario)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun calcularDuracaoTotal(): Int{
        return conteudos.sumOf{it.duracao}
    }
    fun matricular(usuario: Usuario){
        inscritos.add(usuario)
    }
        fun getInscritos(): String {
        return "Alunos inscritos: ${inscritos.joinToString(", ") { it.nome }}"
    }
}

fun main() {
	val usuario0 = Usuario(0,"Matt","mat1",true)
    val usuario1 = Usuario(1,"Lucas","luck",true)
    val usuario2 = Usuario(2,"Nick","fury",true)
    val usuario3 = Usuario(3,"Json","jsoff",false)
    val usuario4 = Usuario(4,"Tatum","tatu1",false)
    val usuario5 = Usuario(5,"Stephen","luck",false)
    val usuario6 = Usuario(6,"Curry","goat",false)
    val usuario7 = Usuario(7,"King","stkg",false)

    val conteudo0 = ConteudoEducacional("Introdução ao Kotlin", 90, usuario0)
    val conteudo1 = ConteudoEducacional("Arrays", 120, usuario0)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120, usuario1)
    val conteudo3 = ConteudoEducacional("Programação Orientada a Objetos 2", 120, usuario1)
    val conteudo4 = ConteudoEducacional("Microsserviços", 120, usuario2)
    val conteudo5 = ConteudoEducacional("Cloud", 120, usuario2)

    val formacao0 = Formacao("Formação Kotlin", mutableListOf(conteudo0, conteudo1), Nivel.BASICO)
    val formacao1 = Formacao("Formação POO", mutableListOf(conteudo2, conteudo3), Nivel.INTERMEDIARIO)
    val formacao2 = Formacao("Formação Arquiteto", mutableListOf(conteudo4, conteudo5), Nivel.AVANCADO)

    formacao0.matricular(usuario3)
    formacao0.matricular(usuario4)
    formacao1.matricular(usuario5)
    formacao1.matricular(usuario6)
    formacao2.matricular(usuario5)
    formacao2.matricular(usuario7)
    formacao2.matricular(usuario6)

    println("Formação: ${formacao0.nome}")
    println("Nível: ${formacao0.nivel}")
    println("Conteúdos:")
    for (conteudo in formacao0.conteudos) {
        println("- ${conteudo.nome}, Duração: ${conteudo.duracao} minutos, Professor: ${conteudo.usuario.nome}")
    }
    println("Tempo total da formação: ${formacao0.calcularDuracaoTotal()} minutos")
    println("${formacao0.getInscritos()}")
    
    println("-----------------------------")
        println("Formação: ${formacao1.nome}")
    println("Nível: ${formacao1.nivel}")
    println("Conteúdos:")
    for (conteudo in formacao1.conteudos) {
        println("- ${conteudo.nome}, Duração: ${conteudo.duracao} minutos, Professor: ${conteudo.usuario.nome}")
    }
    println("Tempo total da formação: ${formacao1.calcularDuracaoTotal()} minutos")
    println("${formacao1.getInscritos()}")
    
    
        println("-----------------------------")
        println("Formação: ${formacao2.nome}")
    println("Nível: ${formacao2.nivel}")
    println("Conteúdos:")
    for (conteudo in formacao2.conteudos) {
        println("- ${conteudo.nome}, Duração: ${conteudo.duracao} minutos, Professor: ${conteudo.usuario.nome}")
    }
    println("Tempo total da formação: ${formacao2.calcularDuracaoTotal()} minutos")
    println("${formacao2.getInscritos()}")
}