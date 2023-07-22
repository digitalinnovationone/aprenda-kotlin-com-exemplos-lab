import domain.ConteudoEducacional
import domain.Formacao
import domain.Usuario
import domain.enums.Cursos
import domain.enums.Nivel
import service.impl.MatricularAlunoImpl

fun main(args: Array<String>) {

    val curso1 = Cursos.JAVA
    val curso2 = Cursos.KOTLIN
    val conteudoEducacional01 = ConteudoEducacional("${curso1} com spring boot", 30)
    val conteudoEducacional02 = ConteudoEducacional("${curso2} com Spring Boot", 45)

    val formacao = Formacao(Cursos.JAVA, mutableListOf(), Nivel.AVANCADO)
    val formacao2 = Formacao(Cursos.KOTLIN, mutableListOf(), Nivel.AVANCADO)
    val matricula = MatricularAlunoImpl(formacao)
    val matricula2 = MatricularAlunoImpl(formacao2)

    val user01 = Usuario(1, "Claudio", "32156487945")
    val user02 = Usuario(2, "Claudio01", "24689751234")
    val user03 = Usuario(3, "Claudio02", "65489712345")


    formacao.adicionarConteudo(conteudoEducacional01)
    formacao.adicionarConteudo(conteudoEducacional02)
    matricula.matricular(user01)
    matricula.matricular(user02)
    matricula2.matricular(user03)
    println("formação : $formacao")
    println("formação inscrito: ${formacao.inscritos}")
    println("formação conteudo: ${formacao.conteudos}")
    matricula.desistir(user02)
    println("formação inscrito: ${formacao2.inscritos}")
}