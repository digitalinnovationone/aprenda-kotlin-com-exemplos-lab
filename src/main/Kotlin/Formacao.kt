data class Formacao(
    val nome: String,
    var conteudos: List<ConteudoEducacional>,
    val nivel: Nivel
) {

    val inscritos = mutableListOf<Usuario>()
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario);
        println("O usuario ${usuario.nome} com ID ${usuario.id} foi matriculado")
    }
}