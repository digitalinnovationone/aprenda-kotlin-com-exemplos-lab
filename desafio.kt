// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

fun main() {
    formacao.component1().matricular(usuario.component1()) //Valen
    formacao.component3().matricular(usuario.component2()) //Lolla
    formacao.component2().matricular(usuario.component3()) //Parker
    formacao.component3().matricular(usuario.component4()) //Ramos

    formacao.component1().exibirInscritos(usuario)

    println("${usuario.component1().name}, Matriculado em: ${usuario.component1().formacao?.name}" +
            "no nível: ${usuario.component1().formacao?.nivel}")
}
