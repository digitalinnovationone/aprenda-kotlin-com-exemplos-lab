enum class Level {
  BASIC,
  INTERMIDIATE,
  ADVANCED
}

open class User(val name: String, val age: Int) {

  fun onNewContent(content: EducationalContent) {
    content.let {
      println(
          "${name} diz: Legal! Agora posso aprender sobre ${it.name} em ${it.durationInMinutes} min"
      )
    }
  }
}

class Student(name: String, age: Int) : User(name, age)

data class EducationalContent(val name: String, val durationInMinutes: Int = 60, val level: Level)

// Classic pub-sub pattern
data class Formation(val name: String, val contentList: MutableList<EducationalContent>) {
  val subscribers = mutableListOf<User>()

  fun subscribe(vararg users: User) {
    users.forEach { user ->
      user.let {
        subscribers.add(it)
        println("${it.name} se matriculou no curso $name")
      }
    }
  }

  fun addContent(content: EducationalContent) {
    contentList.add(content)
    notifyContentAdition(content)
  }

  fun notifyContentAdition(content: EducationalContent) {
    for (subber in subscribers) {
      subber.onNewContent(content)
    }
  }
}

fun main() {

  val jose = Student("José", 19)
  val james = Student("James", 27)
  val jamile = Student("Jamile", 36)

  val aula1 = EducationalContent("Componentes em React", 40, Level.BASIC)
  val aula2 = EducationalContent("Estilização em React", 40, Level.BASIC)
  val aula3 = EducationalContent("Estruturando componentes em React", 40, Level.BASIC)
  val aula4 = EducationalContent("Props de componentes em React", 40, Level.INTERMIDIATE)

  val curso1 = Formation("Iniciando em React", mutableListOf(aula1, aula2, aula3))

  curso1.subscribe(jose)
  curso1.subscribe(james, jamile)

  curso1.addContent(aula4)
}
