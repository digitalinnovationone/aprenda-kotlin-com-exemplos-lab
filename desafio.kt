// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    AVANCADO
}

enum class Genero {
    MASCULINO,
    FEMININO,
    NAO_BINARIO,
    OUTROS
}

data class Usuario(
    val nome: String,
    val dataNascimento: String,
    val genero: Genero,
    val email: String,
    val telefone: String
)

data class ConteudoEducacional(
    val nome: String,
    var duracao: Int = 60,
    val nivel: Nivel
)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: MutableList<ConteudoEducacional>
) {
    private val inscritos = mutableListOf<Usuario>()

    private val duracaoTotal: Int
        get() = conteudos.sumBy { it.duracao / 60 }

    private val usuariosInscritos: Int
        get() = inscritos.size

    fun matricular(usuario: Usuario) {
        if (!existeNaLista(usuario, inscritos)) {
            this.inscritos.add(usuario)
        } else {
            println("Usuário ${usuario.nome} já está matriculado nesta formação.")
        }
    }

    fun matricular(listaUsuarios: List<Usuario>) {
        listaUsuarios.forEach { usuario ->
            if (!existeNaLista(usuario, inscritos)) {
                this.inscritos.add(usuario)
            } else {
                println("Usuário ${usuario.nome} já está matriculado nesta formação.")
            }
        }
    }

    fun desmatricular(usuario: Usuario) {
        if (existeNaLista(usuario, inscritos)) {
            inscritos.remove(usuario)
        } else {
            println("Usuário ${usuario.nome} não está matriculado nesta formação.")
        }
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        if (!existeNaLista(conteudo, conteudos)) {
            conteudos.add(conteudo)
        } else {
            println("Conteúdo ${conteudo.nome} já foi adicionado nesta formação.")
        }
    }

    fun adicionarConteudo(listaConteudos: List<ConteudoEducacional>) {
        listaConteudos.forEach { conteudo ->
            if (!existeNaLista(conteudo, conteudos)) {
                conteudos.add(conteudo)
            } else {
                println("Conteúdo ${conteudo.nome} já foi adicionado nesta formação.")
            }
        }
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        if (existeNaLista(conteudo, conteudos)) {
            conteudos.remove(conteudo)
        } else {
            println("Conteúdo ${conteudo.nome} não está adicionado nesta formação.")
        }
    }

    private fun <T> existeNaLista(objeto: T, lista: List<T>): Boolean {
        return lista.contains(objeto)
    }

    override fun toString(): String {
        return "Formacao { \n" +
                "    Nome: " + this.nome + "\n" +
                "    Duração Total: " + this.duracaoTotal + " hora(s) \n" +
                "    Quantidade de Usuários: " + this.usuariosInscritos + " usuário(s) \n" +
                "    Conteudo(s): ${conteudos.joinToString(", ") { it.nome }} \n" +
                "    Usuário(s) Inscrito(s): ${inscritos.joinToString(", ") { it.nome }} \n" +
                "}"
    }
}

fun main() {
    // Informações geradas com https://www.4devs.com.br/ e conteúdos da DIO

    val usuarios: MutableList<Usuario> = mutableListOf()
    val conteudosEducacionais: MutableList<ConteudoEducacional> = mutableListOf()

    usuarios.add(
        Usuario(
            nome = "Betina Elaine Analu Castro",
            dataNascimento = "03/12/1998",
            genero = Genero.FEMININO,
            email = "betina-castro84@validtecnologia.com.br",
            telefone = "(63) 99465-4114"
        )
    )
    usuarios.add(
        Usuario(
            nome = "Tomás Ricardo Galvão",
            dataNascimento = "14/06/2001",
            genero = Genero.MASCULINO,
            email = "tomas_galvao@creativeinteriores.com.br",
            telefone = "(91) 98879-2308"
        )
    )
    usuarios.add(
        Usuario(
            nome = "Caio Henry Severino Brito",
            dataNascimento = "02/10/1993",
            genero = Genero.NAO_BINARIO,
            email = "caio.henry.brito@folha.com.br",
            telefone = "(71) 98742-8340"
        )
    )

    conteudosEducacionais.add(
        ConteudoEducacional(
            nome = "Trabalhando em Equipes Ágeis",
            duracao = 180,
            nivel = Nivel.BASICO
        )
    )

    conteudosEducacionais.add(
        ConteudoEducacional(
            nome = "Versionamento de Código com Git e Github",
            duracao = 120,
            nivel = Nivel.INTERMEDIARIO
        )
    )
    conteudosEducacionais.add(
        ConteudoEducacional(
            nome = "Conhecendo o kotlin e sua documentação oficial",
            nivel = Nivel.AVANCADO
        )
    )

    val formacao = Formacao(
        nome  = "Desenvolvimento backend com Kotlin",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = mutableListOf(conteudosEducacionais.get(0))
    )

    formacao.matricular(usuarios[0])
    println(formacao)
    println()

    // Adiciona todos os conteudos à formação
    formacao.adicionarConteudo(conteudosEducacionais)
    println(formacao)
    println()

    // Adiciona todos os usuários à formação
    formacao.matricular(usuarios)
    println(formacao)
    println()

    // Remove um conteúdo da formação
    formacao.removerConteudo(conteudosEducacionais[0])
    println(formacao)
    println()

    // Remove um usuário da formação
    formacao.desmatricular(usuarios[0])
    println(formacao)
}
