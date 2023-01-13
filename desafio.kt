enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

data class Aluno(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Aluno>()
    
    fun matricular(aluno: Aluno) {
         inscritos.add(aluno)
    }
    
    fun imprimirListaInscritos(){
        for(user in inscritos){
            println(user.nome)
        }
    }
    
    fun imprimirGradeFormacao(){
        for(cont in conteudos){
            println("${cont.nome} - ${cont.duracao}")
        }
    }
}

fun main() {
    //cursos individuais
    val moduloPython = ConteudoEducacional("curso python", 160)
    val moduloKotlin = ConteudoEducacional("curso kotlin", 60)
    
    val listConteudos = mutableListOf<ConteudoEducacional>()
    listConteudos.add(moduloPython)
    listConteudos.add(moduloKotlin)
    
    //formação completa com todos os cursos
    val formacaoFullstack = Formacao("Formação Fullstack Developer", listConteudos, Nivel.INTERMEDIARIO)
    
    //Criar lista de usuarios
    val André = Aluno("André", "dede@gmail.com")
    val Bruna = Aluno("Bruna", "bruna@gmail.com")
    
    //matriculando usuarios na formação
    formacaoFullstack.matricular(André)
    formacaoFullstack.matricular(Bruna)
    
    println("======================================")
    println("Dados da formação")
    println("${formacaoFullstack.nome} - ${formacaoFullstack.nivel}")
    println("Grade formação")
    println(formacaoFullstack.imprimirGradeFormacao())
    println("=======================================")
    println("Lista de inscritos")
    println(formacaoFullstack.imprimirListaInscritos())
}