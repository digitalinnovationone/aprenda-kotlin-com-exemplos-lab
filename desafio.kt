enum class NivelEnum { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(var nome: String, var idade: Number)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: NivelEnum ) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        this.inscritos.add(usuario)
    }
}

fun main() {
    val listaFormacao = mutableListOf<Formacao>()
    listaFormacao.add(Formacao(
        nome = "Programação básica", 
        conteudos = listOf(
        	ConteudoEducacional(
            	nome= "Algoritmo",
            ),
            ConteudoEducacional(
            	nome= "Estrutura de dados",
                duracao = 120
            )
        ),
        nivel= NivelEnum.BASICO
    ))
    listaFormacao.add(Formacao(
        nome = "Orientação a objetos", 
        conteudos = listOf(
        	ConteudoEducacional(
            	nome= "Herança"
            ),
            ConteudoEducacional(
            	nome= "Polimorfismo",
                duracao = 80
            )
        ),
        nivel= NivelEnum.INTERMEDIARIO
    ))
    
    val thagner = Usuario(nome= "Thagner Moreira Uramoto", idade=35) 
    
    listaFormacao[0].matricular(thagner)
    listaFormacao[0].matricular(
        Usuario(nome= "João da Silva Sauro", idade=26)
    )
    listaFormacao[0].matricular(
        Usuario(nome= "Maria Luisa", idade=23)
    )
    
    listaFormacao[1].matricular(thagner)
    listaFormacao[1].matricular(
        Usuario(nome= "João Antunes", idade=48)
    )
    
    println("Formações: \r\n")
    
    listaFormacao.forEach {
        println("\t ${it.nome}   nível: ${it.nivel.toString()}")
        println("\t\t Alunos matriculados: ${it.inscritos.size}")
        
        it.inscritos.forEach { inscrito -> println("\t\t\t ${inscrito.nome} ${inscrito.idade} anos")}
    }
    
    
}
