// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class UsuarioInvalidoException (message: String) : Exception(message)

data class Usuario (val nome: String, val email: String){

    fun Validar() {
        val builder = StringBuilder()
        
        if(nome.isEmpty()) builder.append("O nome do Usuário não foi informado. Verifique!\n") 
        
        if(email.isEmpty()) builder.append("O e-mail do Usuário não foi informado. Verifique!\n") 
        
        if(builder.length != 0) throw UsuarioInvalidoException(builder.toString())
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel : Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        try {
            
            usuario.Validar()
            inscritos.add(usuario)
            println("=============================================")
            println("O aluno ${usuario.nome} foi matriculado com o e-mail: ${usuario.email}")
            println("=============================================\n")
            
        }   catch(e: UsuarioInvalidoException){
            println("=============================================")
            println("O usuário não foi vinculado")
            println(e.message)
            println("=============================================\n")
        }
    }
    
    fun gerarMassaAlunos(){
        
        for (i in 1..500) {
    		inscritos.add(Usuario("Aluno ${i}", "email${i}@email.com"))
		}
    }
    
    fun listarAlunos(){
        for(inscrito in inscritos){
            println("=============================================")
            println("O aluno ${inscrito.nome} foi matriculado com o e-mail: ${inscrito.email}")
            println("=============================================\n")
        }
        	
    }
}

fun main() {
    val listConteudoKotlin = mutableListOf<ConteudoEducacional>()
    listConteudoKotlin.add(ConteudoEducacional("Primeiros Passos", 10))
    listConteudoKotlin.add(ConteudoEducacional("Substituindo o Java", 100))
    listConteudoKotlin.add(ConteudoEducacional("Web com Kotlin", 100))
   
    val formacaoKotlin = Formacao("Formação Kotlin", Nivel.AVANCADO, listConteudoKotlin);

    val usuarioValido =  Usuario("Ricardo", "ricardo@ricardo.com");
    val usuarioInValidoNome =  Usuario("", "email@email.com");
    val usuarioInValidoEmail =  Usuario("NOME", "");
    val usuarioInvalido =  Usuario("", "");

    formacaoKotlin.matricular(usuarioValido);
    formacaoKotlin.matricular(usuarioInValidoNome);
    formacaoKotlin.matricular(usuarioInValidoEmail);
    formacaoKotlin.matricular(usuarioInvalido);
    
    formacaoKotlin.gerarMassaAlunos()
    
    formacaoKotlin.listarAlunos()
       
}
