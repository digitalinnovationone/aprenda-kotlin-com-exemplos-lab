// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { INICIANTE, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val idade: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(
    val nome: String,
    val conteudos: List<ConteudoEducacional>,
    val nivel: Nivel = Nivel.INICIANTE
) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios) {
            if (usuario in inscritos) {
                println("Usuário: ${usuario.nome} já cadastrado!")
            } else {
                inscritos.add(usuario)
            }
        }
    }
}

fun main() {
    val usuario = Usuario("Jose Pedro", 30)
    val usuario2 = Usuario("Sandra", 22)
    val usuario3 = Usuario("Eren", 19)
    val usuario4 = Usuario("Eren", 19)

    val conteudoAula = ConteudoEducacional("OO", 32)
    val conteudoAula2 = ConteudoEducacional("Projetos e desafios", 122)

    val curso1 = Formacao("Kotlin", listOf(conteudoAula), Nivel.INICIANTE)
    val curso2 = Formacao("Kotlin com Desafios", listOf(conteudoAula, conteudoAula2), Nivel.INTERMEDIARIO)

    curso1.matricular(usuario, usuario2)
    curso2.matricular(usuario3, usuario3, usuario4)

    println("\nInscritos no Curso: ${curso1.nome}")
    for (inscrito in curso1.inscritos) {
        println("Nome: ${inscrito.nome}. Idade: ${inscrito.idade}")
    }

    println("Inscritos no Curso: ${curso2.nome}")
    for (inscrito in curso2.inscritos) {
        println("Nome: ${inscrito.nome}. Idade: ${inscrito.idade}")
    }
}
