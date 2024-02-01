enum class Level { BASIC, MID_LEVEL, HARD }

data class EducationalContent(val title: String, val duration: Int = 60)

data class User(val name: String)

class AlreadyRegisteredUser(msg: String) : Throwable(msg)

data class Formation(
        private val title: String,
        private val level: Level,
        private val contents: List<EducationalContent>
) {
    private val subscribers = mutableListOf<User>()
    val subs: List<User> get() = subscribers

    fun enroll(user: User) {
        if (!subscribers.contains(user)) {
            subscribers.add(user)
        } else {
            throw AlreadyRegisteredUser("Usuário ${user.name} já inscrito no curso $title.")
        }
    }
}

fun getSpringBootEducationContent() = listOf(EducationalContent("Kotlin"), EducationalContent("Spring"))

fun main() {
    val formation = Formation("Spring boot com Kotlin", Level.MID_LEVEL, getSpringBootEducationContent())
    val usersToSubscribe = listOf(
            User("José"),
            User("Maria"),
            User("João"),
            User("José")
    )

    usersToSubscribe.forEach {
        try {
            formation.enroll(it)
        } catch (ex: AlreadyRegisteredUser) {
            println(ex.message)
        }
    }

    println("Registros terminados. Alunos registrados: ${formation.subs}")
}