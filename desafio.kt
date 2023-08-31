class Usuario (val nome: String)

enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    DIFICIL
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (usuario.nome.isBlank()) {
            throw IllegalArgumentException("Nome do usuário não pode ser vazio")
        } else if (inscritos.contains(usuario)) {
            throw IllegalArgumentException("${usuario.nome} já está matriculado(a) nesta formação.")
        }
        inscritos.add(usuario)
        println("Parabéns ${usuario.nome}, você foi matriculado(a) com sucesso na formação $nome")
    }

    fun listarInscritos() {
        if (inscritos.isEmpty()) {
            println("Não há inscritos nesta formação.")
        } else {
            println("Lista de Inscritos na Formação $nome:")
            for (inscrito in inscritos) {
                println(inscrito.nome)
            }
        }
    }
}

fun validarMatricula(usuario: Usuario, formacao: Formacao) {
    try {
        formacao.matricular(usuario)
    } catch (e: IllegalArgumentException) {
        println("Erro ao matricular: ${e.message}")
    }
}


fun main() {
    val usuarioRodrigo = Usuario("Rodrigo")
    val usuarioLeticia = Usuario("Leticia")
    val usuarioSemNome = Usuario("")

    val listaConteudoAndroid = listOf(
        ConteudoEducacional("Conhecendo o Kotlin", 1),
        ConteudoEducacional("Introdução a prática à linguagem Kotlin", 2),
        ConteudoEducacional("Estruturas de controle", 2),
        ConteudoEducacional("Orientação a Objetos", 2),
    )
    val listaConteudoIOS = listOf(
        ConteudoEducacional("Conhecendo o Swift", 1),
        ConteudoEducacional("Introdução a prática à linguagem Swift", 2),
        ConteudoEducacional("Estruturas de controle", 2),
        ConteudoEducacional("Orientação a Objetos", 2),
    )

    val formacaoAndroid = Formacao("Fundamentos Android", Nivel.BASICO, listaConteudoAndroid)
    val formacaoIOS = Formacao("Fundamentos IOS", Nivel.BASICO, listaConteudoIOS)

    println(formacaoAndroid)
    println(formacaoIOS)

    validarMatricula(usuarioRodrigo, formacaoAndroid)
    validarMatricula(usuarioLeticia, formacaoAndroid)
    validarMatricula(usuarioSemNome, formacaoIOS)
    validarMatricula(usuarioRodrigo, formacaoAndroid)

    formacaoAndroid.listarInscritos()
    formacaoIOS.listarInscritos()


}