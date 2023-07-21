package domain

import domain.enums.Nivel

data class Formacao(val nome: String,var conteudos: MutableList<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()


    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    fun adicionarConteudo(conteudoEducacional: ConteudoEducacional){
        conteudos.add(conteudoEducacional)
    }
}
