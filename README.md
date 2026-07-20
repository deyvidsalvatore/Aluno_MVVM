# AlunoMVVM

Aplicativo Android de demonstração construído com Jetpack Compose e MVVM. Permite cadastrar alunos com duas notas, listar/remover alunos e visualizar um resumo com contagem de aprovados, em recuperação e reprovados.

Principais funcionalidades
- Cadastro de aluno com validação de notas (0 a 10)
- Listagem de alunos com remoção
- Tela de resumo com contagens por situação (Aprovado, Em Recuperação, Reprovado)
- Dados iniciais (mock) carregados no ViewModel

Tecnologias
- Kotlin
- Jetpack Compose
- Arquitetura MVVM (ViewModel + StateFlow)
- Navigation Compose

Estrutura relevante
- app/src/main/java/com/capgemini/deyvidsilva/aluno/
  - MainActivity.kt          -> Entrada do app, configura NavGraph e tema
  - model/Aluno.kt           -> Data class Aluno (média e situação calculadas)
  - model/Situacao.kt        -> Enum com descrições das situações
  - viewmodel/AlunoViewModel.kt -> Lógica de negócio e estado (MutableStateFlow)
  - navigation/NavGraph.kt   -> Rotas e navegação (NavRoutes)
  - screens/CadastroScreen.kt-> Tela de cadastro e listagem
  - screens/ResumoScreen.kt  -> Tela de resumo com contagens
  - ui/components/*          -> Componentes reutilizáveis (cards, botões, textfields)
  - ui/theme/*               -> Tema e cores do app

Requisitos
- Android Studio com suporte a Jetpack Compose
- JDK 11
- Gradle (wrapper fornecido)

Como executar
1. Abrir o projeto no Android Studio
2. Sincronizar o Gradle
3. Executar no emulador ou dispositivo físico (minSdk 24)

Build pela linha de comando
- Windows: .\gradlew assembleDebug
- Para limpar: .\gradlew clean

Testes
- Inclui testes de exemplo em app/src/test e androidTest. Executar via Android Studio ou gradlew.

Observações de implementação
- ViewModel inicializa uma lista mock de Alunos (carregarMock)
- Validações na tela de cadastro impedem inserção de notas inválidas
- Identificadores de aluno são gerados por timestamp por padrão
