enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val id: Int, val nome: String)

data class ConteudoEducacional(val nome: String, var duracao: Int = 60, val nivel: Nivel = Nivel.BASICO) {
    init {
        duracao /= 60
    }
}

data class Formacao(val nome: String) {
    private val inscritos = mutableListOf<Usuario>()
    private val conteudos = mutableListOf<ConteudoEducacional>()

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun listarConteudos() {
        println("Conteúdos da formação $nome:")
        for (conteudo in conteudos) {
            println("- ${conteudo.nome} - Duração: ${conteudo.duracao} horas - Nível: ${conteudo.nivel}")
        }
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("\n-> ${usuario.nome} matriculado na formação $nome.")
    }

    fun listarInscritos() {
        println("\nInscritos na formação $nome:")
        for (inscrito in inscritos) {
            println("- ${inscrito.nome}")
        }
    }
}

fun main() {
    val usuario1 = Usuario(0, "Edson Ottoni")
    val usuario2 = Usuario(1, "Leandro Otoni")

    val conteudo1 = ConteudoEducacional("Principios de Agilidade e Desenvolvimento Colaborativo", 420, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Aprendendo kotlin na Prática em sua documentação oficial", 780, Nivel.BASICO)
    val conteudo3 = ConteudoEducacional("Praticando Sua Logica de Programação com Kotlin", 360, Nivel.INTERMEDIARIO)
    val conteudo4 = ConteudoEducacional("Explorando Padrões de Projeto em Kotlin", 300, Nivel.INTERMEDIARIO)
    val conteudo5 = ConteudoEducacional("Entendendo Banco de Dados SQL e NoSQL", 360, Nivel.INTERMEDIARIO)
    val conteudo6 = ConteudoEducacional("Kotlin no Backend com Spring Boot 3", 600, Nivel.DIFICIL)

    val formacao = Formacao("Desenvolvimento Backend com Kotlin")
    formacao.adicionarConteudo(conteudo1)
    formacao.adicionarConteudo(conteudo2)
    formacao.adicionarConteudo(conteudo3)
    formacao.adicionarConteudo(conteudo4)
    formacao.adicionarConteudo(conteudo5)
    formacao.adicionarConteudo(conteudo6)

    formacao.listarConteudos()

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    formacao.listarInscritos()
}
