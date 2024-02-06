

enum class Level { BASIC, INTERMEDIARY, HARD}

class User

data class EducationalContent (var name: String, val duration: Int = 60)

data class Formacao(val name: String, var content: List<EducationalContent>) {

    val registered = mutableListOf<User>()
    
    fun enroll(user: User) {
        TODO("Utilize o parâmetro $user para simular uma matrícula (usar a lista de $registered).")
    }
}

fun main() {
    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
