package domain

import domain.enums.Cursos
import domain.enums.Nivel

data class Formacao(val tipo: Cursos, var conteudos: MutableList<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun adicionarConteudo(conteudoEducacional: ConteudoEducacional){
        conteudos.add(conteudoEducacional)
    }
}
