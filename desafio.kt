
class DIO {

    private val formacoes: MutableList<Formacao> = mutableListOf()
    private val usuarios: MutableList<Usuario> = mutableListOf()

    constructor() {
    }

    fun adicionarFormacao(formacao: Formacao) {
        this.formacoes.add(formacao)
    }

    fun adicionarUsuario(usuario: Usuario) {
        usuario.id = usuarios.size + 1
        this.usuarios.add(usuario)
    }

    fun getFormacoes(): List<Formacao> {
        return this.formacoes
    }

    fun getUsuarios(): List<Usuario> {
        return this.usuarios
    }

}
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario {
    var id: Int
    var nome: String

    constructor( nome: String) {
        this.id = 0
        this.nome = nome

        fun getId(): Int {
            return this.id
        }

        fun setId(nome: String) {
            this.id = id
        }

        fun getNome(): String {
            return this.nome
        }

        fun setNome(nome: String) {
            this.nome = nome
        }

    }
}

data class ConteudoEducacional(
    private var nome: String,
    private var duracao: Int
)

data class Formacao(
    private var nome: String,
    private var conteudos: MutableList<ConteudoEducacional>,
    private var inscritos: MutableList<Usuario>,
    private var nivel: Nivel
) {
    fun getNome(): String {
        return this.nome
    }
    fun setNome(nome: String) {
        this.nome = nome
    }
    fun getConteudos(): MutableList<ConteudoEducacional> {
        return this.conteudos
    }
    fun addConteudo(conteudo: ConteudoEducacional) {
        this.conteudos.add(conteudo)
    }
    fun getNivel(): Nivel {
        return this.nivel
    }
    fun setNivel(nivel: Nivel) {
        this.nivel = nivel
    }
    fun getAlunosMatriculados(): MutableList<Usuario> {
        return this.inscritos
    }
    fun matricular(usuario: Usuario) {
//         TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
            println("Matriculando usuario")
        DIO().adicionarUsuario(usuario);
        var ultimoRegistrado = DIO().getUsuarios().lastOrNull()
        if(ultimoRegistrado != null) {
            inscritos.add(ultimoRegistrado)
        } else {
            println("Falha ao matricular usuario")
        }
    }
}

fun main() {
//     TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
//     TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    val formacao1 = Formacao(
        nome = "Guia Scrum",
        conteudos = mutableListOf(
            ConteudoEducacional("O que é Scrum", 20),
            ConteudoEducacional("Como implementar Scrum", 40)
        ),
        inscritos = mutableListOf(),
        nivel = Nivel.BASICO
    )

    val aluno1 = Usuario( "Samuel Registro1")
    formacao1.matricular(aluno1)

    println(" Cadastrado usuer1 cadastrada com sucesso!")
    val aluno2 = Usuario("Samuel Registro2")
    formacao1.matricular(aluno2)

    DIO().adicionarFormacao(formacao1)
    var ultimaFormacao = DIO().getFormacoes().lastOrNull()
    if (ultimaFormacao != null ) {
        println(" Formacao ${ultimaFormacao.getNome()} cadastrada com sucesso!")
    } else {
        print("Ocorreu um erro ao adicinar Formacao")
    }

    val formacao2 = Formacao(
        nome = "Git do Zero",
        conteudos = mutableListOf(
            ConteudoEducacional("A importancia do Git", 5),
            ConteudoEducacional("Preparativos para usar o Git", 5),
            ConteudoEducacional("Dominando o Git - Parte 1", 5),
            ConteudoEducacional("Dominando o Git - Parte 2", 5),
            ConteudoEducacional("Dominando o Git - Parte 3", 5),
            ConteudoEducacional("Como implementar Scrum", 40)
        ),
        inscritos = mutableListOf(),
        nivel = Nivel.BASICO
    )

    val aluno3 = Usuario( "Samuel Registro 3")
    val aluno4 = Usuario( "Samuel Registro 4")
    val aluno5 = Usuario( "Samuel Registro 5")


//    dio.getFormacoes().forEach {
//            formacao -> println(formacao.getNome())
//        println(formacao.getNivel())
//        formacao.getConteudos()
//        formacao.getAlunosMatriculados().forEach{
//                usuario -> println("--- ${usuario.id} ${usuario.nome} ")
//        }
//    }

}
