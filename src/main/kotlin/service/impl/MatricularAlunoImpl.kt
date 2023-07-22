package service.impl

import domain.Formacao
import domain.Usuario
import domain.enums.Cursos
import domain.enums.Nivel
import service.MatriculaAluno

class MatricularAlunoImpl(private val formacao: Formacao) : MatriculaAluno {

    constructor() : this(Formacao(Cursos.JAVA, mutableListOf(), Nivel.BASICO))

    override fun matricular(usuario: Usuario) {
        formacao.inscritos.add(usuario)
    }

    override fun desistir(usuario: Usuario): Usuario? {
        val removedUser = formacao.inscritos.remove(usuario)
        return if (removedUser) usuario else null
    }
}