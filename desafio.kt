// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String) {
    override fun toString(): String {
        return nome
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome")
    }

    fun desmatricular(usuario: Usuario) {
        inscritos.remove(usuario)
        println("Usuário ${usuario.nome} desmatriculado da formação $nome")
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo ${conteudo.nome} adicionado à formação $nome")
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        conteudos.remove(conteudo)
        println("Conteúdo ${conteudo.nome} removido da formação $nome")
    }

    override fun toString(): String {
        return "Formação: $nome | Nível: $nivel | Conteúdos: $conteudos | Inscritos: $inscritos"
    }
}

fun main() {
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    val conteudo1 = ConteudoEducacional("Introdução a Programação", 60)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 80)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados", 100)

    val formacao1 = Formacao("Formação de Desenvolvimento Web", Nivel.INTERMEDIARIO, mutableListOf(conteudo1, conteudo2))
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)

    val formacao2 = Formacao("Formação de Ciência de Dados", Nivel.AVANCADO, mutableListOf(conteudo1, conteudo3))
    formacao2.matricular(usuario1)

    println(formacao1)
    println(formacao2)

    formacao1.desmatricular(usuario2)
    formacao2.adicionarConteudo(conteudo2)
    formacao2.removerConteudo(conteudo1)

    println(formacao1)
    println(formacao2)
}
