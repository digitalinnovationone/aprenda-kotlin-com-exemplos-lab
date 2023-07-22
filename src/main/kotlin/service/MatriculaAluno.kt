package service

import domain.Usuario

interface MatriculaAluno {
    fun matricular(usuario: Usuario)
    fun desistir(usuario: Usuario)
}