data class User (val name: String, val id: Int, val email: String, val age: Int)

data class EducationContent (val name: String, val duration: Int, val description: String)

data class Formation (val name: String, val level: String, var content: MutableList<EducationContent>) {
    val registered = mutableListOf<User>()
    
    fun register(user: User) {
        registered.add(user)
        println("User ${user.name} registered for the $name formation.")
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }   

}


fun main() {
    
   	//Criando instâncias de EducationContent
    val content1 = EducationContent("POO", 60, "Introdução a Orientação a objetos")
    val content2 = EducationContent("Design System", 45, "Design System na prática")
    val content3 = EducationContent("SGBD", 55, "Banco de dados")
    
    //Criando uma lista de EducationContent
    val contentList = mutableListOf(content1, content2, content3)
    
    //Criando uma instância de Formation
    val formation = Formation("Backend", "Medio", contentList)
    
    //Criando um usuário
    val user = User("Guilherme", 1,"guilherme@email.com", 26)
    
    formation.register(user)
    
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}