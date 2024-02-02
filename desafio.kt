// Conteúdos e Formações possuem diferentes níveis de dificuldade
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

// Usuários da plataforma DIO
data class Usuario(val nome: String, val id: Int){

    // Informa os dados do usuário
    fun informacoes() {
        println("- Informações do usuário - ")
        println("Nome: ${this.nome}. Número de Identificação: ${this.id}.")
    }
}

// Conteúdos das Formações da plataforma DIO
data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

// Formações da DIO
data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableSetOf<Usuario>()

    // Informa pontos importantes sobre a formação
    fun informacoes() {
        println("- Informações importantes -")
        println("Formação: ${this.nome}. Dificuldade: ${this.nivel.name}.")
        println("Número de conteudos: ${conteudos.size}. Número de inscritos atuais: ${inscritos.size}.")
    }

    // Realiza a matrícula de um usuário
    fun matricular(usuario: Usuario) {
        if(inscritos.contains(usuario)){
            println("Usuário já matriculado.")
        }else{
            inscritos.add(usuario)
            println("O(A) usuário(a) ${usuario.nome} foi matriculado(a) com sucesso na formação ${this.nome}.")
        }
    }

    // Lista as informações sobre os conteúdos da formação
    fun listar_conteudos() {
        println("Lista dos conteudos da formação ${this.nome}:")
        for(conteudo in conteudos){
            println(" - ${conteudo.nome} - ${conteudo.duracao} min - ${conteudo.nivel.name}")
        }
    }

    // Lista os inscritos atuais da formação
    fun listar_inscritos() {
        println("Lista dos inscritos na formação ${this.nome}:")
        for(inscrito in inscritos){
            println(" - ${inscrito.nome}, Id:${inscrito.id}")
        }
    }

}

fun main() {

    // Simulação de cenário de teste:

    val c1 = ConteudoEducacional("Algoritmo de Dijkstra", 180, Nivel.DIFICIL)
    val c2 = ConteudoEducacional("Algoritmo de Floyd-Warshall", 120, Nivel.INTERMEDIARIO)
    val c3 = ConteudoEducacional("Algoritmo de Busca em Profundidade", 60, Nivel.BASICO)
    val CursoKotlin = Formacao("Algoritmos de programação em Kotlin", listOf(c1, c2, c3), Nivel.INTERMEDIARIO)

    val aluno1 = Usuario("Cleber", 1001)
    val aluno2 = Usuario("Cleide", 2010)

    aluno1.informacoes()

    CursoKotlin.matricular(aluno1)
    CursoKotlin.matricular(aluno1)  // Mesmo ao tentar matricular o mesmo usuário, apenas um aparecerá na lista
    CursoKotlin.listar_inscritos()

    CursoKotlin.matricular(aluno2)
    CursoKotlin.listar_inscritos()

    CursoKotlin.informacoes()
    CursoKotlin.listar_conteudos()
}
