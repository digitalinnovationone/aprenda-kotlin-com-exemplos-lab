import kotlin.text.uppercase //Importando a Função UpperCase()

class Usuario(val nome: String, val id: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var nivel: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    //Adicionando um Usuário e Verificando se Houve Alguma Duplicação de Usuários
    fun matricular(usuario: Usuario) {
        if(usuario !in inscritos) {
            inscritos.add(usuario)
            println("O usuário ${usuario.nome.uppercase()}, portador do id: (${usuario.id}), agora está matriculado na formação ${nome.uppercase()}. Nível: $nivel!")
            println("") //Espaço de Parágrafo Para Melhor Visibilidade na Saída do Terminal
        } else {
            println("O usuário ${usuario.nome} já está matriculado!".uppercase())
            println("") //Espaço de Parágrafo Para Melhor Visibilidade na Saída do Terminal
        }
    }
}

fun main() {
    
    //Início de Usúarios Inscritos na Plataforma
    
    val usuario1 = Usuario("Pedro Thiago", 23)
    val usuario2 = Usuario("Ezequiel", 45)
    val usuario3 = Usuario("Carlos", 56)
    
    //Final de Usúarios Inscritos na Plataforma
    
    //Início Conteúdos de Cada Formação
    
    val conteudos_kotlin = listOf(
        ConteudoEducacional("Tratamento de Exceções em Kotlin", 120),  
        ConteudoEducacional("Programação Orientada a Objetos", 180)
    )
    
    val conteudos_PHP = listOf(
        ConteudoEducacional("Introdução a PHP", 120),  
        ConteudoEducacional("Programação Orientada a Objetos", 180)
    )
    
    //Final Conteúdos de Cada Formação
    
    //Início de Formações De cada Usúario
    
    val formacao_kotlin = Formacao("Kotlin Back-end Developer", "Intermediário".uppercase(), conteudos_kotlin)
    val formacao_PHP = Formacao("PHP Experience", "Avançado".uppercase(), conteudos_PHP)
    
    
    //Final de Formações De cada Usúario
    
    //Início das Matriculações de Cada Usúario em Formações
    
    formacao_kotlin.matricular(usuario1)
    formacao_PHP.matricular(usuario2)
    formacao_kotlin.matricular(usuario1) //Teste de duplicação
    formacao_kotlin.matricular(usuario3)
    
    //Final das Matriculações de Cada Usúario em Formações
    
    println("Inscritos na Formação Kotlin Back-end Developer: ${formacao_kotlin.inscritos.map {it.nome}}") //Imprimindo o Nome dos Inscritos na Formação Kotlin
    println("Inscritos na Formação PHP Experience: ${formacao_PHP.inscritos.map {it.nome}}") //Imprimindo o Nome dos Inscritos na Formação PHP Experience
    
}