package me.dio.desafioprojetoKotlin.Ariel

enum class Nivel { Basico, Intermediario, Avançado }

data class Aluno(val nome: String, val id: Int)

data class ConteudoEducacional(val nome: String, var duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Aluno>()
    
    fun matricular(vararg alunos: Aluno) {
       for(aluno in alunos)
        inscritos.add(aluno) 
    }
    fun listaDeInscritos(){
   		for(inscrito in inscritos){
        println(inscrito.nome)
    	}
    } 
    
    fun listaDeConteudos (){
        for(cont in conteudos){
        println("${cont.nome} - ${cont.duracao}")
       }
    }   
}

fun main() {
    
    val linguagemKotlin1 = ConteudoEducacional("POP-Programação orientada a Objeto",60)
    val linguagemKotlin2 = ConteudoEducacional("Tipos de classes",60)
    
     
    val ListaConteudos = mutableListOf<ConteudoEducacional>()
    ListaConteudos.add(linguagemKotlin1)
    ListaConteudos.add(linguagemKotlin2)
    
    val FormacaoConhecendoKotlin = Formacao("Formação conhecendo a linguagem Kotlin", ListaConteudos, Nivel.Basico)
      
    val aluno1 = Aluno("Ariel",1 )
    val aluno2 = Aluno("Wallace", 2)
    val aluno3 = Aluno("Amanda", 3)
    
    FormacaoConhecendoKotlin.matricular(aluno1)
    FormacaoConhecendoKotlin.matricular(aluno2)
    FormacaoConhecendoKotlin.matricular(aluno3)
    
    println("Dados da Formação")
    println("${FormacaoConhecendoKotlin.nome} - ${FormacaoConhecendoKotlin.nivel}")
    println("Lista dos conteúdos:")
    println(FormacaoConhecendoKotlin.listaDeConteudos())
    println(".........................................................")
    println("Lista dos Matriculados")
    println(FormacaoConhecendoKotlin.listaDeInscritos())
 }
 