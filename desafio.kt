enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(var nome: String, var email:String)

data class Modulo(val id:Int, val nome:String, val cursos:Map<String, Set<Curso>>,val palavraChave:String)

data class Curso(val id: Int, val nome:String, val conteudos:MutableList<Pair<String,Int>>, val palavraChave:String)

data class ConteudosEducacionais(val conteudoMap: Map<Int, MutableList<Pair<String, Int>>>)


data class Formacao(val nome: String, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    val conteudosMap: MutableMap<Int, MutableList<Pair<String, Int>>> = mutableMapOf()
    val cursosSet: MutableSet<Curso> = mutableSetOf()
    val modulosSet: MutableSet<Modulo> = mutableSetOf()
    
    
    fun matricular(vararg usuarios: Usuario) {
        usuarios.forEach {u -> inscritos.add(u)}
    }
    
    
    fun criarConteudos(vararg conteudos:String, id:Int) {
        val conteudosList: MutableList<Pair<String, Int>> = mutableListOf()
        var duracaoVideo = 1;
        
      	conteudos.forEach {c -> 
            duracaoVideo += (Math.random() * 19).toInt()
            conteudosList.add( Pair(c, duracaoVideo) )
        }
        
        conteudosMap.put(id, conteudosList)
        ConteudosEducacionais(conteudosMap)
    }
    
    
    fun criarCurso(nome:String, id:Int, palavraChave:String) { 
    	for((chave,valor) in conteudosMap) {
			if(chave == id) {
				Curso(id,nome,valor, palavraChave).apply{ cursosSet.add(this) }  
            }else {
				println("não achamos os conteudos educacionais correspondentes a esse curso para esse $id")
            }
        }
    }
    
    
    fun criarModulo(nome:String, id:Int, palavraChave:String) {
        val cursosParaCadaModuloSet: MutableSet<Curso> = mutableSetOf()
        val cursosParaCadaModuloMap: MutableMap<String, Set<Curso>> = mutableMapOf()
        
    	cursosSet.forEach {c ->
        	if(c.palavraChave == palavraChave) { cursosParaCadaModuloSet.add(c) }
        }
        
        cursosParaCadaModuloMap.put(palavraChave, cursosParaCadaModuloSet)
        
        Modulo(id, nome, cursosParaCadaModuloMap, palavraChave).apply { modulosSet.add(this) }
    }
    
    fun exibirFormacaoCompleta() {
        println("Numero de Modulos: ${modulosSet.size}")
            modulosSet.forEach {m -> 
                println("(Modulo): ${m.nome} | (ID): ${m.id}") 
            } 
        
        println("Numero de Cursos: ${cursosSet.size}")
            cursosSet.forEach {c -> 
                println("(curso): ${c.nome} | (ID): ${c.id}") 
            }    
            
       println("Numero de conteúdos: ${conteudosMap.size}")
            for((chave,valor) in conteudosMap) { println("(Conteúdos): $valor | (ID): $chave") }
    }
}

fun main() {
    
    val formacaoKotlin:Formacao = Formacao("Code Update TQI - Backend com Kotlin e Java", Nivel.INTERMEDIARIO)
 
    formacaoKotlin.criarConteudos(	"extension Functions",
									"infix Functions",
                                  	"suspend Functions", 
                                  	"Lambda Functions",
                                  	id = 20)
    
     formacaoKotlin.criarConteudos(	"enum class",
									"data class",
                                  	"Object keyWord", 
                                  	"Sealed class",
                                  	id = 30)
    formacaoKotlin.criarCurso("o poder das funções em Kotlin", 20, "Kotlin")
    formacaoKotlin.criarCurso("Orientação a Objetos e Tipos de Classes na Prática com Kotlin", 30, "Kotlin")
    formacaoKotlin.criarModulo("Desmitificando Kotlin para programadores java",2, "Kotlin")
    
    formacaoKotlin.exibirFormacaoCompleta()
}