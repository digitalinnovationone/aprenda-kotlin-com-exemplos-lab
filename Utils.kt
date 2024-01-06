val usuario: List<Usuario> = listOf(
    Usuario(name = "Valentina"),
    Usuario(name = "Lolla"),
    Usuario(name = "Parker"),
    Usuario(name = "Ramos")
)

val conteudo: List<ConteudoEducacional> = listOf(
    ConteudoEducacional(nome = "Linguagem Koltin", duracao = 120),
    ConteudoEducacional(nome = "Algoritmos", duracao = 240),
    ConteudoEducacional(nome = "Android Mobile", duracao = 120),
    ConteudoEducacional(nome = "Estatística", duracao = 180),
    ConteudoEducacional(nome = "Programação Orientada a Objetos", 180)
)

val formacao: List<Formacao> = listOf(
    Formacao(name = "Analista de Dados", conteudos = conteudo, nivel = Nivel.BASICO),
    Formacao(name = "Análise Dados", conteudos = conteudo, Nivel.INTERMEDIARIO),
    Formacao(name = "Analista de Dados", conteudos = conteudo, Nivel.DIFICIL),
)