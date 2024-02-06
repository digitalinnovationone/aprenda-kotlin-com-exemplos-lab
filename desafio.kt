

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if(!inscritos.contains(usuario)){
            inscritos.add(usuario)
            println("${usuario.nome} matriculado na $nome")
        }else{
            println("${usuario.nome} já está matriculado nesta formação")
        }
    }
    fun cancelarMatricula(usuario: Usuario){
        if(inscritos.contains(usuario)){
            inscritos.remove(usuario)
            println("${usuario.nome} teve sua matrícula cancelada na $nome")
        } else{
            println("${usuario.nome} não está matriculado nesta formação")
        }
    }
    fun usuarioEstaInscrito(usuario: Usuario): Boolean{
        return inscritos.contains(usuario)
    }
}


fun main() {

}
