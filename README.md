# Aprenda Kotlin Com Exemplos: Desafio de Projeto (Lab)

Desafio de Projeto criado para avaliação do conteúdo técnico explorado no repositório [aprenda-kotlin-com-exemplos](https://github.com/digitalinnovationone/aprenda-kotlin-com-exemplos). **Nesse contexto, iremos abstrair o seguinte domínio de aplicação:**

**A [DIO](https://web.dio.me) possui `Formacoes` incríveis que têm como objetivo oferecer um conjunto de `ConteudosEducacionais` voltados para uma stack tecnológica específica, preparando profissionais de TI para o mercado de trabalho. `Formacoes` possuem algumas características importantes, como `nome`, `nivel` e seus respectivos `conteudosEducacionais`. Além disso, tais experiências educacionais têm um comportamento relevante ao nosso domínio, definido pela capacidade de `matricular` um ou mais `Alunos`.**


```kotlin
TODO("Crie uma solução em Koltin abstraindo esse domínio. O arquivo [desafio.kt] te ajudará 😉")
```

# Saída após a execução
Usuário João matriculado na formação Formação de Desenvolvimento Web
Usuário Maria matriculado na formação Formação de Desenvolvimento Web
Usuário João matriculado na formação Formação de Ciência de Dados
Formação: Formação de Desenvolvimento Web | Nível: INTERMEDIARIO | Conteúdos: [ConteudoEducacional(nome=Introdução a Programação, duracao=60), ConteudoEducacional(nome=Estruturas de Dados, duracao=80)] | Inscritos: [João, Maria]
Formação: Formação de Ciência de Dados | Nível: AVANCADO | Conteúdos: [ConteudoEducacional(nome=Introdução a Programação, duracao=60), ConteudoEducacional(nome=Algoritmos Avançados, duracao=100)] | Inscritos: [João]
Usuário Maria desmatriculado da formação Formação de Desenvolvimento Web
Conteúdo Estruturas de Dados adicionado à formação Formação de Ciência de Dados
Conteúdo Introdução a Programação removido da formação Formação de Ciência de Dados
Formação: Formação de Desenvolvimento Web | Nível: INTERMEDIARIO | Conteúdos: [ConteudoEducacional(nome=Introdução a Programação, duracao=60), ConteudoEducacional(nome=Estruturas de Dados, duracao=80)] | Inscritos: [João]
Formação: Formação de Ciência de Dados | Nível: AVANCADO | Conteúdos: [ConteudoEducacional(nome=Algoritmos Avançados, duracao=100), ConteudoEducacional(nome=Estruturas de Dados, duracao=80)] | Inscritos: [João]


