enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

open class Usuario(val login: String, val senha: String)

class Aluno(login: String, senha: String, val nome: String, val matricula: Long, var formacao: Formacao? = null) : Usuario(login, senha) {
    override fun toString(): String {
        return "Aluno(nome='$nome', matricula=$matricula, formacao=$formacao)"
    }
}

data class ConteudoEducacional(val titulo: String, val duracao: Int = 60)

data class Formacao(val titulo: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Aluno>()
    
    fun matricular(aluno: Aluno) {
        inscritos.add(aluno)
        aluno.formacao = this
    }
    
    fun printInscritos() {
        println(inscritos)
    }
}

fun printFormacao(formacao: Formacao) {
    with(formacao) {
        println("Formação: $titulo - Nível: $nivel")

        if (conteudos.isNotEmpty()) {
            println("Conteúdos:")
            conteudos.forEach {
                println(" - ${it.titulo} (${it.duracao} minutos)")
            }
        } else {
            println("Esta formação não possui conteúdos educacionais cadastrados.")
        }

        if (inscritos.isNotEmpty()) {
            println("Inscritos:")
            inscritos.forEach {
                println(" - Nome: ${it.nome}, Matrícula: ${it.matricula}")
            }
        } else {
            println("Nenhum aluno inscrito nesta formação.")
        }
    }
    println()
}

fun main() {
	// Criação de conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 120)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados", 150)
    val conteudo4 = ConteudoEducacional("Desenvolvimento Mobile", 100)
    val conteudo5 = ConteudoEducacional("Bancos de Dados", 110)
    val conteudo6 = ConteudoEducacional("Interfaces de Usuário", 120)
    
    // Criação de formações
    val formacaoBasico = Formacao("Programação Básica", Nivel.BASICO, listOf(conteudo1, conteudo2, conteudo3))
    val formacaoIntermediario = Formacao("Desenvolvimento Mobile", Nivel.INTERMEDIARIO, listOf(conteudo4, conteudo5, conteudo6))
    
    // Criação de alunos
    val aluno1 = Aluno("maria.pontes", "senha123", "Maria Pontes", 202300520L)
    val aluno2 = Aluno("joao.oliveira", "senha456", "João Oliveira", 202300852L)
    val aluno3 = Aluno("ana.silva", "senha789", "Ana Silva", 202301234L)
    val aluno4 = Aluno("carlos.rodrigues", "senha101", "Carlos Rodrigues", 202301345L)
    val aluno5 = Aluno("lucas.mendes", "senha567", "Lucas Mendes", 202301567L)
    
    // Matricular alunos nas formações
    formacaoBasico.matricular(aluno1)
    formacaoBasico.matricular(aluno2)
    formacaoIntermediario.matricular(aluno3)
    formacaoIntermediario.matricular(aluno4)
    formacaoIntermediario.matricular(aluno5)
    
    // Imprimir formações e inscritos
    printFormacao(formacaoBasico)
    printFormacao(formacaoIntermediario)
}