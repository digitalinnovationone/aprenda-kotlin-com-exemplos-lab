data class Formacao(
    val name: String,
    var conteudos: List<ConteudoEducacional>,
    var nivel: Nivel
) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        usuario.formacao = this
        runCatching {
            if (!inscritos.contains(usuario)) {
                inscritos.add(usuario)
            } else {
                println("O usuário ${usuario.name} já está matriculado na Formação de $name $nivel")
            }
        }.onSuccess { println("${usuario.name} matriculado na formação de $name $nivel") }
            .onFailure { exception ->
                Throwable(exception.message)
            }
    }

    fun exibirInscritos(usuarios: List<Usuario>) {
        val inscritos = usuarios.size
        println("Há ${inscritos} usuários inscritos na Formação de $name):")
    }
}
