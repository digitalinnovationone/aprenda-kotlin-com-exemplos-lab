// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario
// Classe principal representando uma Formação DIO
class Formacao(
    val nome: String,
    val nivel: Nivel,
    val conteudosEducacionais: List<ConteudoEducacional>
) {

    // Enumeração para os diferentes níveis de Formação
    enum class Nivel {
        INICIANTE,
        INTERMEDIARIO,
        AVANÇADO
    }

    // Classe para representar um Conteúdo Educacional
    class ConteudoEducacional(
        val titulo: String,
        val tipo: TipoConteudo
    ) {

        // Enumeração para os diferentes tipos de Conteúdo Educacional
        enum class TipoConteudo {
            AULA,
            EXERCICIO,
            PROJETO
        }
    }
	
	//Função que matricula o Aluno
	fun matricularAluno(formacao: Formacao, aluno: Aluno) {
    // Verifica se o aluno já está matriculado
    if (formacao.isAlunoMatriculado(aluno)) {
        println("Aluno ${aluno.nome} já está matriculado na formação ${formacao.nome}")
        return
    }
    
    // Adiciona o aluno à lista de alunos matriculados
    formacao.alunosMatriculados.add(aluno)

    // Envia um email de confirmação para o aluno
    // TODO: Implementar envio de email

    println("Aluno ${aluno.nome} matriculado com sucesso na formação ${formacao.nome}")
}
    
    // Função para verificar se um Aluno está matriculado na Formação
    fun isAlunoMatriculado(aluno: Aluno): Boolean {
	    for (formacao in formacoes) {
        if (formacao.isAlunoMatriculado(aluno)) {
            return true
        }
    }
    return false
}
    }
}

// Exemplo de uso da classe Formacao
val formacaoAndroidKotlin = Formacao(
    nome = "Formação Android com Kotlin",
    nivel = Formacao.Nivel.INTERMEDIARIO,
    conteudosEducacionais = listOf(
        ConteudoEducacional(
            titulo = "Introdução ao Kotlin",
            tipo = ConteudoEducacional.TipoConteudo.AULA
        ),
        ConteudoEducacional(
            titulo = "Criando sua primeira tela Android",
            tipo = ConteudoEducacional.TipoConteudo.EXERCICIO
        ),
        ConteudoEducacional(
            titulo = "Aplicativo de lista de tarefas",
            tipo = ConteudoEducacional.TipoConteudo.PROJETO
        )
    )
)

val formacaoIntroducaoProgramacao = Formacao(
    nome = "Formação Introdução à Programação",
    nivel = Formacao.Nivel.INICIANTE,
    conteudosEducacionais = listOf(
        ConteudoEducacional(
            titulo = "Conceitos básicos de programação",
            tipo = ConteudoEducacional.TipoConteudo.AULA
        ),
        ConteudoEducacional(
            titulo = "Variáveis, tipos de dados e operadores",
            tipo = ConteudoEducacional.TipoConteudo.AULA
        ),
        ConteudoEducacional(
            titulo = "Estruturas de controle: if, else e for",
            tipo = ConteudoEducacional.TipoConteudo.AULA
        ),
        ConteudoEducacional(
            titulo = "Lógica de programação e resolução de problemas",
            tipo = ConteudoEducacional.TipoConteudo.EXERCICIO
        ),
        ConteudoEducacional(
            titulo = "Criando seu primeiro programa",
            tipo = ConteudoEducacional.TipoConteudo.PROJETO
        )
    )
)

val formacaoDesenvolvimentoWebAvancado = Formacao(
    nome = "Formação Desenvolvimento Web Avançado",
    nivel = Formacao.Nivel.AVANÇADO,
    conteudosEducacionais = listOf(
        ConteudoEducacional(
            titulo = "Arquitetura de aplicações web complexas",
            tipo = ConteudoEducacional.TipoConteudo.AULA
        ),
        ConteudoEducacional(
            titulo = "Microsserviços e APIs RESTful",
            tipo = ConteudoEducacional.TipoConteudo.AULA
        ),
        ConteudoEducacional(
            titulo = "Segurança em aplicações web",
            tipo = ConteudoEducacional.TipoConteudo.AULA
        ),
        ConteudoEducacional(
            titulo = "Desenvolvimento de APIs com Spring Boot",
            tipo = ConteudoEducacional.TipoConteudo.EXERCICIO
        ),
        ConteudoEducacional(
            titulo = "Criando uma aplicação web completa",
            tipo = ConteudoEducacional.TipoConteudo.PROJETO
        )
    )
)

val alunoIntermediario = Aluno("Felipe Rocha")
val alunoAvancado = Aluno("Ana Carolina")
val alunoIniciante = Aluno("Heitor")

formacaoAndroidKotlin.matricularAluno(alunoInterMediano)
formacaoIntroducaoProgramacao.matricularAluno(alunoIniciante)
formacaoDesenvolvimentoWebAvancado.matricularAluno(alunoAvancado)

if (formacaoIntroducaoProgramacao.isAlunoMatriculado(alunoIniciante)) {
    println("Aluno ${alunoIniciante.nome} está matriculado na formação ${formacaoIntroducaoProgramacao.nome}")
} else {
    println("Aluno ${alunoIniciante.nome} não está matriculado na formação ${formacaoIntroducaoProgramacao.nome}")
}
if (formacaoDesenvolvimentoWebAvancado.isAlunoMatriculado(alunoAvancado)) {
    println("Aluno ${alunoAvancado.nome} está matriculado na formação ${formacaoDesenvolvimentoWebAvancado.nome}")
} else {
    println("Aluno ${alunoAvancado.nome} não está matriculado na formação ${formacaoDesenvolvimentoWebAvancado.nome}")
}
if (formacaoAndroidKotlin.isAlunoMatriculado(alunoMediano)) {
    println("Aluno ${alunoMediano.nome} está matriculado na formação ${formacaoAndroidKotlin.nome}")
} else {
    println("Aluno ${alunoMediano.nome} não está matriculado na formação ${formacaoAndroidKotlin.nome}")
}

