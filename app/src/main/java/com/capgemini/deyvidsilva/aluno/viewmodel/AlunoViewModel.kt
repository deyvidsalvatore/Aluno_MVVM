package com.capgemini.deyvidsilva.aluno.viewmodel

import androidx.lifecycle.ViewModel
import com.capgemini.deyvidsilva.aluno.model.Aluno
import com.capgemini.deyvidsilva.aluno.model.Situacao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AlunoViewModel : ViewModel() {

    private val _alunos = MutableStateFlow<List<Aluno>>(emptyList())
    val alunos = _alunos.asStateFlow()

    init {
        carregarMock()
    }

    private fun carregarMock() {
        _alunos.value = listOf(

            Aluno(id = 1, nome = "Ana Silva", nota1 = 8.0, nota2 = 9.0),
            Aluno(id = 2, nome = "Bruno Costa", nota1 = 7.5, nota2 = 8.5),
            Aluno(id = 3, nome = "Carlos Souza", nota1 = 9.0, nota2 = 7.0),
            Aluno(id = 4, nome = "Daniela Lima", nota1 = 10.0, nota2 = 9.5),
            Aluno(id = 5, nome = "Eduardo Alves", nota1 = 7.0, nota2 = 7.0),

            Aluno(id = 6, nome = "Fernanda Rocha", nota1 = 5.0, nota2 = 5.5),
            Aluno(id = 7, nome = "Gabriel Martins", nota1 = 6.0, nota2 = 5.5),
            Aluno(id = 8, nome = "Helena Oliveira", nota1 = 6.5, nota2 = 5.5),
            Aluno(id = 9, nome = "Igor Santos", nota1 = 5.0, nota2 = 6.0),
            Aluno(id = 10, nome = "Juliana Pereira", nota1 = 5.5, nota2 = 6.0),

            Aluno(id = 11, nome = "Kevin Rodrigues", nota1 = 4.0, nota2 = 3.5),
            Aluno(id = 12, nome = "Larissa Gomes", nota1 = 2.5, nota2 = 4.0),
            Aluno(id = 13, nome = "Marcos Ferreira", nota1 = 1.0, nota2 = 3.0),
            Aluno(id = 14, nome = "Natália Barbosa", nota1 = 4.5, nota2 = 4.0),
            Aluno(id = 15, nome = "Otávio Ribeiro", nota1 = 0.0, nota2 = 2.0)
        )
    }


    val aprovados
        get() = contagemPorSituacao(Situacao.APROVADO);

    val recuperacao
        get() = contagemPorSituacao(Situacao.EM_RECUPERACAO);

    val reprovados
        get() = contagemPorSituacao(Situacao.REPROVADO)

    fun adicionarAluno(
        nome: String,
        nota1: Double,
        nota2: Double
    ) {
        _alunos.value += Aluno(
            nome = nome,
            nota1 = nota1,
            nota2 = nota2
        )
    }

    fun removerAluno(id: Long) {
        _alunos.value =
            _alunos.value.filterNot { it.id == id}
    }

    fun contagemPorSituacao(situacao: Situacao): Int {
        return alunos.value.count {
            it.situacao == situacao
        }
    }

}