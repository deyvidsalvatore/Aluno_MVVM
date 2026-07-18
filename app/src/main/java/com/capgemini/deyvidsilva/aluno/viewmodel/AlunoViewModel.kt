package com.capgemini.deyvidsilva.aluno.viewmodel

import androidx.lifecycle.ViewModel
import com.capgemini.deyvidsilva.aluno.model.Aluno
import com.capgemini.deyvidsilva.aluno.model.Situacao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AlunoViewModel : ViewModel() {

    private val _alunos = MutableStateFlow<List<Aluno>>(emptyList())

    val alunos = _alunos.asStateFlow()

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