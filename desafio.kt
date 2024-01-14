import java.time.LocalDate
import java.time.Period

enum class Log { DEBUG, INFO, ERROR }

fun printLog(type: Log = Log.DEBUG, message: String) {
    val reset = "\u001b[0m"
    val red = "\u001b[31m"
    val green = "\u001B[32m"
    val blue = "\u001B[34m"
    when (type) {
        Log.INFO -> println("$green $message \n $reset")
        Log.DEBUG -> println("$blue $message \n $reset")
        Log.ERROR -> println("$red $message \n $reset")
    }
}

enum class Level { BASIC, INTERMEDIARY, ADVANCED }

data class User(val name: String, val birthDate: LocalDate) {

    private val pointsLimitLevel: Int = 500
    private var pointsCurrent: Int = 0
    var level: Level = Level.BASIC
        private set

    private val age: Int = Period.between(birthDate, LocalDate.now()).years

    fun addPoints(points: Int) {
        pointsCurrent += points
        if (pointsCurrent >= pointsLimitLevel) {
            levelUp()
            pointsCurrent -= pointsLimitLevel
        }
    }

    private fun levelUp() {
        level = when (level) {
            Level.BASIC -> Level.INTERMEDIARY
            Level.INTERMEDIARY -> Level.ADVANCED
            Level.ADVANCED -> Level.ADVANCED
        }
    }

    fun info() {
        printLog(
            Log.INFO, """
            Nome: $name, Idade: $age, Nivel: $level, Pontos: $pointsCurrent 
        """.trimIndent()
        )
    }
}

data class EducationalContent(val name: String, val duration: Int = 60, val level: Level, val author: String)

data class Training(
    val name: String,
    private val contents: List<EducationalContent>?,
    val level: Level,
    val points: Int,
) {
    private val _subscribers = mutableListOf<User>()
    private val _contents = mutableListOf<EducationalContent>()

    init {
        contents?.forEach { addContents(it) }

        printLog(
            message = """
            Treinamento $name Criado com sucesso e com o nivel: $level ao finalizar 
            todos os conteudos sera adicionando a sua pontuação $points pontos
            ${
                if (_contents.size > 0) ", conteudos presente são: ${_contents.map { it.name }}"
                else ""
            }""".trimIndent()
        )
    }

    fun info() {
        printLog(
            Log.INFO, """
            Nome: $name, Nivel: $level, pontos: $points
            Conteudos: ${_contents.map { it.name }} 
            Inscritos: 
            ${
                if (_subscribers.size > 0) _subscribers.map { it.name }.toString() else "Sem inscritos"
            }
        """.trimIndent()
        )
    }

    fun subscribe(user: User) {
        if (user.level.ordinal >= level.ordinal) {
            printLog(message = "Estudante ${user.name} inscrito com sucesso!")
            _subscribers.add(user)
        } else printLog(Log.ERROR, "Erro ao tentar adicionar estudante, level inferior ao do treinamento")
    }

    fun addContents(vararg contents: EducationalContent) {
        contents.forEach {
            if (it.level.ordinal <= level.ordinal) _contents.add(it)
            else printLog(Log.ERROR, "Level do conteudo maior que a do treinamento")
        }
    }

    fun finish(approved: List<User>) {
        approved.filter { _subscribers.contains(it) }
            .forEach {
                printLog(Log.INFO, "Estudante: ${it.name} formado com sucesso!!")
                it.addPoints(points)
                _subscribers.remove(it)
            }
    }
}

fun main() {
    // Create contents
    val contentLevel1 =
        EducationalContent(
            name = "Kotlin Basico",
            author = "Dio",
            level = Level.BASIC,
            duration = 60 * 30
        )
    val contentLevel2 = EducationalContent(
        name = "Kotlin Intermediario",
        author = "Dio",
        level = Level.INTERMEDIARY,
        duration = 60 * 45
    )
    val contentLevel3 =
        EducationalContent(
            name = "Kotlin Avançado",
            author = "Dio",
            level = Level.ADVANCED,
            duration = 60 * 80
        )

    // Create Training
    val trainingLevel1 =
        Training(
            name = "Treinamento Basico de Kotlin",
            level = Level.BASIC,
            points = 550,
            contents = listOf(
                EducationalContent(
                    name = "Preparação de Ambiente",
                    author = "Dio",
                    level = Level.BASIC,
                    duration = 60 * 2
                ),
                EducationalContent(
                    name = "Orientação a Objeto",
                    author = "Dio",
                    level = Level.BASIC,
                    duration = 60 * 15
                )
            )
        )

    val trainingLevel2 = Training(
        name = "Treinamento Intermediario de Kotlin",
        level = Level.INTERMEDIARY,
        points = 700,
        contents = listOf(
            EducationalContent(
                name = "Tratamentos de erros",
                author = "Dio",
                level = Level.INTERMEDIARY,
                duration = 60 * 2
            ),
            EducationalContent(
                name = "Utilizando principios de programação funcional",
                author = "Dio",
                level = Level.INTERMEDIARY,
                duration = 60 * 15
            )
        )
    )

    // create students
    val student1 = User(name = "João", LocalDate.of(2000, 4, 20))
    val student2 = User(name = "Jose", LocalDate.of(2012, 6, 15))
    val student3 = User(name = "Maria", LocalDate.of(2014, 2, 10))


    // Cases with success
    // Add students in training with success
    trainingLevel1.subscribe(student1)
    trainingLevel1.subscribe(student2)
    trainingLevel1.subscribe(student3)
    trainingLevel1.info()

    // Approve students in training
    trainingLevel1.finish(listOf(student3, student1))
    trainingLevel1.info()
    student1.info()

    // Add approved e new training
    trainingLevel2.subscribe(student3)
    trainingLevel2.info()

    //Cases with errors
    // Add content in training with error
    trainingLevel1.addContents(contentLevel2)
    trainingLevel1.info()
    // Add students in training with error
    trainingLevel2.subscribe(student2)
    trainingLevel2.info()
}

