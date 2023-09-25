enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val id: Long, val name: String)

data class ConteudoEducacional(val id: Long, var nome: String, val duracao: Int = 60)

data class Formacao(val id: Long, val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        this.inscritos.add(usuario)
    }
}

fun main() {
    val joseUsuario = Usuario(1L, "José")
	val oliveiraUsuario = Usuario(2L, "Oliveira")
    
    val dockerConteudo = ConteudoEducacional(1L, "Docker Fundamentals", 120)
    val kubernetesConteudo = ConteudoEducacional(12, "Kubernetes Fundamentals", 180)
    val conteudos = listOf(dockerConteudo, kubernetesConteudo)
    
    val formacao = Formacao(1L, "DevOps Fundamentals", Nivel.INTERMEDIARIO, conteudos)
    formacao.matricular(joseUsuario)
    formacao.matricular(oliveiraUsuario)
    
    println("Formação: $formacao")
	println("Inscritos: ${formacao.inscritos}")
}
