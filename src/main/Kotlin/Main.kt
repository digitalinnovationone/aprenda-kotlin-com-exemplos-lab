fun main() {
    val cursos = mutableListOf<Formacao>()
    cursos.add(
        Formacao(
            nome = "Orientação a objetos em kotlin", conteudos = listOf(
                ConteudoEducacional(
                    nome = "Classes e Propriedades", duracao = 30
                )
            ), nivel = Nivel.BASICO
        ))


    cursos.add(
        Formacao(
            nome = "Herança", conteudos = listOf(
                ConteudoEducacional(
                    nome = "Poliformismo, encapsulamento e interface",
                    duracao = 10
                )
            ), nivel = Nivel.INTERMEDIARIO
        ))

    cursos.add(
        Formacao(
            nome = "Conceitos avançados", conteudos = listOf(
                ConteudoEducacional(
                    nome = "Composição",
                    duracao = 10
                )
            ), nivel = Nivel.DIFICIL
        ))

    //Cadastro de um novo aluno que posssui um nome e um id;
    val renan = Usuario(id = 1, nome = "Renan")
    cursos[0].matricular(renan)

    val eduardo = Usuario(id = 2, nome = "Eduardo")
    cursos[0].matricular(eduardo)

    val maria = Usuario(id = 3, nome = "Maria")
    cursos[1].matricular(maria)


    //impressão da lista de alunos e seus respectivos aspectos (nome e id)
    cursos.forEach {
        println("${it.nome}, ${it.nivel.toString()}")

        println("Número de alunos matriculados: ${it.inscritos.size}")
        println("Lista de alunos: \n")
        it.inscritos.forEach { inscritos ->
            println("${inscritos.nome}")
        }
    }
}