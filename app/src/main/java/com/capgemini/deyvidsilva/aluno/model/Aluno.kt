package com.capgemini.deyvidsilva.aluno.model

data class Aluno(
    val id: Long = System.currentTimeMillis(),
    val nome: String,
    val nota1: Double,
    val nota2: Double
) {
    val media: Double
        get() = (nota1 + nota2) / 2

    val situacao: Situacao
        get() = when {
            media >= 7 -> Situacao.APROVADO
            media >= 5 -> Situacao.EM_RECUPERACAO
            else -> Situacao.REPROVADO
        }
}