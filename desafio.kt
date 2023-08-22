// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }
enum class Categoria {FRONT_END, BACK_END, FULL_STACK, MOBILE}

fun extractCategoria(categoria: Categoria):String{

     when(categoria){
        Categoria.FRONT_END -> return "Front-End"
         Categoria.MOBILE -> return "Mobile"
         Categoria.FULL_STACK -> return "Full Stack"
         Categoria.BACK_END -> return "Back-End"
         else -> {
             return "Sem Categoria"
         }
     }
}

fun extractNivel(nivel: Nivel):String{

    when(nivel){
        Nivel.DIFICIL -> return "Dificil"
        Nivel.INTERMEDIARIO -> return "Intermediário"
        Nivel.BASICO -> return "Básico"
        else -> {
            return "Sem Nível"
        }
    }
}
data class Usuario(private val id:Int, private var nome: String, private var email: String, private var dataNasc: String){

//    private var nome: String = "";
//    private var email: String = "";
//    private var dataNasc: String = "";
//    private var formacoes: ArrayList<Formacao> = TODO();

    fun getId():Int{
        return id;
    }

    fun getNome():String{
        return nome;
    }

    fun setNome(nome:String){
        this.nome = nome;
    }

    fun getEmail():String{
        return email;
    }

    fun setEmail(email:String){
        this.email = email;
    }

    fun getDataNasc():String{
        return dataNasc;
    }

    fun setDataNAsc(dataNasc:String){
        this.dataNasc = dataNasc;
    }
}

//class AlunoFormacoes(aluno:Usuario, formacoes:ArrayList<Formacao>) {
//    fun addFormacao(formacao: Formacao) {
//        addFormacao(formacao);
//    }
//
//    fun getData(id: Int) {
//
//    }
//}
data class ConteudoEducacional(private val id: Int, val nome: String, val duracaoHora: Int = 1){
    fun getId():Int{
        return id;
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val categoria: Categoria, val nivel: Nivel, val vagas: Int) {

    val inscritos = mutableListOf<Usuario>()
    fun matricular(vararg usuario: Usuario) {
            for (user in usuario) if(inscritos.contains(user)) println("Usuário ja cadastrado") else if(inscritos.size < vagas)inscritos.add(inscritos.size, user) else println("Todas as vagas foram preenchidas!" +
                    "\nSelecione outro curso");
            return;
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }
    fun getAlunos(){
        println("\nAlunos Matriculados na Formação de $nome")
        for(i in 0..inscritos.size - 1) println(" ${i + 1} - ${inscritos[i].getNome()}")
    }

    fun getConteudosEducacionais(){
        println("\nConteúdos Educacionais de $nome: ")
        for(i in 0..conteudos.size - 1) println("${(i+1)} - ${conteudos[i].nome}");
    }

    fun removeAluno(id: Int){
        var removeu = try{ inscritos.removeAt(id); true} catch (e: Throwable){ false}
        if(removeu){
            println("Removido com Sucesso")
            return;
        }
        println("Não Removeu!");
    }

    override fun toString(): String {
        return "\nDados da Formação de $nome" +
                "\nALuno Matriculados: ${inscritos.size}" +
                "\nConteudos Educacionais: ${conteudos.size}" +
                "\nCategoria:  ${extractCategoria(categoria)}" +
                "\nNível: ${extractNivel(nivel)}"
    }

}

fun main() {
    println("Fazendo");
//    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
//    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    val user = Usuario(0, "Felipe", "felipe@gmail.com", "22/01/2004");
    val user1 = Usuario(1, "Ana", "ana@gmail.com", "15/05/1990")
    val user2 = Usuario(2, "Carlos", "carlos@gmail.com", "10/11/1985")
    val user3 = Usuario(3, "Maria", "maria@gmail.com", "03/07/2000")
    val user4 = Usuario(4, "Pedro", "pedro@gmail.com", "28/09/1998")

    //Conteudos Educacionais
    var conteudo = ConteudoEducacional(0, "Estrutura de Dados", 2)
    val conteudo1 = ConteudoEducacional(1, "Introdução à Programação", 4)
    val conteudo2 = ConteudoEducacional(2, "Algoritmos e Estruturas de Dados", 6)
    val conteudo3 = ConteudoEducacional(3, "Banco de Dados Relacionais", 3)
    val conteudo4 = ConteudoEducacional(4, "Desenvolvimento Web", 5)
    val conteudo5 = ConteudoEducacional(5, "Machine Learning Fundamentals", 7)
    val conteudo6 = ConteudoEducacional(6, "Sistemas Operacionais", 4)
    val conteudo7 = ConteudoEducacional(7, "Segurança da Informação", 6)
    val conteudo8 = ConteudoEducacional(8, "Programação Orientada a Objetos", 5)
    val conteudo9 = ConteudoEducacional(9, "Inteligência Artificial", 8)

    var conteudos:List<ConteudoEducacional> = listOf<ConteudoEducacional>(conteudo, conteudo2);
    val conteudos1: List<ConteudoEducacional> = listOf(conteudo, conteudo2)
    val conteudos2: List<ConteudoEducacional> = listOf(conteudo3, conteudo4, conteudo5)
    val conteudos3: List<ConteudoEducacional> = listOf(conteudo6, conteudo7, conteudo8)
    val conteudos4: List<ConteudoEducacional> = listOf(conteudo9, conteudo1)

    val javaAvancado = Formacao("Java Avançado", conteudos1, Categoria.BACK_END, Nivel.INTERMEDIARIO, 2 )
    val Node = Formacao("Java Avançado", conteudos1, Categoria.BACK_END, Nivel.INTERMEDIARIO, 1 )
    val webSuperSayajin = Formacao("Web Super Sayajin", conteudos4, Categoria.FULL_STACK, Nivel.DIFICIL, 5);

    //javaAvancado.matricular(user, user1, user2);
    javaAvancado.matricular(user);
    //mesmo usuário verificação e bloquei dele se ja cadastrado
    javaAvancado.matricular(user);
    javaAvancado.matricular(user1);
    javaAvancado.matricular(user2);
    //verifica Alunos Matriculados
    println(javaAvancado.getAlunos());

    //remove Aluno de Formação
    javaAvancado.removeAluno(1);
    //Adiciona novo user após remoção
    javaAvancado.matricular(user2);
    //verific Alunos
    println(javaAvancado.getAlunos())

    //Verifica Conteudos
    println(javaAvancado.getConteudosEducacionais())

    //Dados
    println(javaAvancado.toString())

    //Node

    //WebSuperSayjain
    webSuperSayajin.matricular(user, user1, user2, user3, user4);

    webSuperSayajin.getAlunos()

    webSuperSayajin.getConteudosEducacionais()

    println( webSuperSayajin.toString());
}
