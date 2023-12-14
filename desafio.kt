enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

  val inscritos = mutableListOf<Usuario>()

  fun matricular(vararg usuarios: Usuario) {
    inscritos.addAll(usuarios)
    for (usuario in usuarios) {
      println("${usuario.nome} matriculado em $nome com sucesso.")
    }

  }

  override fun toString(): String {
    return """
      
            Está é a formação $nome, ela contem os seguintes 
            cursos $conteudos, o seu nivel é $nivel hoje temos ${inscritos.size} matriculados
        """.trimIndent()
  }
}

fun fakeNames(): MutableList<Usuario>{
  val usersNames: MutableList<String> = mutableListOf()
  var usuarios: MutableList<Usuario> = mutableListOf()
  for (i in 1..20){
    usersNames.add("name$i")
  }

  for (user in usersNames){
    var userName = Usuario(user)
    usuarios.add(userName)
  }
  return usuarios
}

fun main() {
  var names = fakeNames();
  val cursoAngular = ConteudoEducacional("Curso Angular 8+", 120)
  val cursoSpring = ConteudoEducacional("Curso Spring Framework Completo", 240)
  val cursoIntroducaoKotlin = ConteudoEducacional("Curso Kotlin Iniciante", 30)
  val cursoJavaWeb = ConteudoEducacional("Curso Java Web", 120)
  val cursoJs = ConteudoEducacional("JavaScript", 20)
  val cursoAgile = ConteudoEducacional("Agile", 60)

  val formacaoAngular = Formacao("Angular", listOf(cursoAngular), Nivel.INTERMEDIARIO)
  val formacaoSpring = Formacao("Spring", listOf(cursoSpring), Nivel.INTERMEDIARIO)
  val formacaoKotlin = Formacao("Curso Kotlin Iniciante", listOf(cursoIntroducaoKotlin), Nivel.INTERMEDIARIO)
  val formacaoJavaWeb = Formacao("Java Web Fullstack", listOf(cursoJavaWeb), Nivel.INTERMEDIARIO)

  for(i in 0..names.size-1) {
    var x = names.indexOf(Usuario("name$i"))
    if (names.indexOf(Usuario("name$i")) % 5 == 0) {
      formacaoSpring.matricular(names[i])
    } else if (names.indexOf(Usuario("name$i")) % 3 == 0) {
      formacaoKotlin.matricular(names[i])
    } else if (names.indexOf(Usuario("name$i")) % 2 == 0) {
      formacaoJavaWeb.matricular(names[i])
    } else if (names.indexOf(Usuario("name$i")) % 3 != 0) {
      formacaoAngular.matricular(names[i])
    }
  }

  println(formacaoAngular)
  print("\n")
  println(formacaoSpring)
  print("\n")
  println(formacaoJavaWeb)
  print("\n")
  println(formacaoKotlin)
}
