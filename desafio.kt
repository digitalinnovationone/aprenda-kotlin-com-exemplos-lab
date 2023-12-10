// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nomeUsuario: String, val matriculaUsuario : Int) {
    override fun toString(): String {
        return "$nomeUsuario (matricula $matriculaUsuario)"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    override fun toString() : String {
        return "$nome, com duração de $duracao)"
    }
}

data class Formacao(val nome: String,var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.addAll(usuario)
    }
    
    override fun toString(): String {
        //Organiza o retorno para o usuário visualizar a saída do programa
        return """
        Curso: $nome
        Conteúdo: $conteudos
        Nível: $nivel
        Alunos inscritos: $inscritos
        """
    }
}

fun main() {
   // TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
   //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
   
   val gilson = Usuario("Gilson", 111111)
   val anne = Usuario("Anne", 121212)
   val guilly = Usuario("Guilly", 222222)
   val bruna = Usuario("Bruna", 333333)
   val ana = Usuario("Ana", 444444)
   
   val conteudoAngular = ConteudoEducacional("Curso Angular 8+", 120)
   val conteudoSpring = ConteudoEducacional("Curso Spring Framework Completo", 240)
   val conteudoPl = ConteudoEducacional("Curso PL/SQL", 30)
   val conteudoJavaWeb = ConteudoEducacional("Curso Java Web", 120)
   val conteudoGit = ConteudoEducacional("Git", 10)
   val conteudoAgile = ConteudoEducacional("Agile", 60)
   
   val formacaoAngular = Formacao("Angular", listOf(conteudoAngular), Nivel.INTERMEDIARIO)
   val formacaoSpring = Formacao("Spring", listOf(conteudoSpring), Nivel.INTERMEDIARIO)
   val formacaoPL = Formacao("PL/SQL", listOf(conteudoPl), Nivel.INTERMEDIARIO)
   val formacaoJavaWeb = Formacao("Java Web Fullstack", listOf(conteudoJavaWeb), Nivel.INTERMEDIARIO)
   val formacaoGit = Formacao("Git", listOf(conteudoGit), Nivel.BASICO)
   val formacaoAgile = Formacao("Agile", listOf(conteudoAgile), Nivel.INTERMEDIARIO)
   
   formacaoAngular.matricular(gilson, anne, guilly, bruna, ana)
   formacaoSpring.matricular(gilson, anne, bruna, ana)
   formacaoPL.matricular(gilson, anne)
   formacaoJavaWeb.matricular(gilson, anne, ana)
   formacaoGit.matricular(ana, bruna)
   formacaoAgile.matricular(gilson, anne, guilly)
   
   println(formacaoAngular)
   print("\n")
   println(formacaoSpring)
   print("\n")
   println(formacaoPL)
   print("\n")
   println(formacaoJavaWeb)
   print("\n")
   println(formacaoGit)
   print("\n")
   println(formacaoAgile)
   print("\n")

}


