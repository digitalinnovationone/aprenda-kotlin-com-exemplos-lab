import domain.ConteudoEducacional
import domain.Formacao
import domain.Usuario
import domain.enums.Cursos
import domain.enums.Nivel
import service.impl.MatricularAlunoImpl

fun main() {

    val curso1 = Cursos.JAVA
    val curso2 = Cursos.KOTLIN
    val conteudoEducacional01 = ConteudoEducacional("${curso1} com spring boot", 30)
    val conteudoEducacional02 = ConteudoEducacional("${curso2} com Spring Boot", 45)

    val formacao = Formacao(curso1, mutableListOf(), Nivel.AVANCADO)
    val formacao2 = Formacao(curso2, mutableListOf(), Nivel.AVANCADO)
    val matricula = MatricularAlunoImpl(formacao)
    val matricula2 = MatricularAlunoImpl(formacao2)

    val user01 = Usuario(1, "Claudio", "32156487945")
    val user02 = Usuario(2, "Fulano01", "24689751234")
    val user03 = Usuario(3, "Claudio02", "65489712345")


    formacao.adicionarConteudo(conteudoEducacional01)
    formacao2.adicionarConteudo(conteudoEducacional02)
    matricula.matricular(user01)
    matricula.matricular(user02)
    matricula2.matricular(user03)
    println("formação ${formacao.linguagem} : $formacao")
    println("formação ${formacao2.linguagem} : $formacao2")
    println("formação ${formacao.linguagem} inscritos: ${formacao.inscritos}")
    println("formação ${formacao.linguagem}  conteudo: ${formacao.conteudos}")
    val userRemovido = matricula.desistir(user02)
    println("formação ${formacao2.linguagem} inscritos: ${formacao2.inscritos}")

    if (userRemovido != null) {
        println("Na formação ${formacao.linguagem} o Aluno ${userRemovido.nome} desistiu dos inscritos.")
    }
    println("formação ${formacao.linguagem} inscritos: ${formacao.inscritos}")
}