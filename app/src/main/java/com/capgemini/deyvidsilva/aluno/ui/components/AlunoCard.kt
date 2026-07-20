package com.capgemini.deyvidsilva.aluno.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.capgemini.deyvidsilva.aluno.model.Aluno

@Composable
fun AlunoCard(
    aluno: Aluno,
    onExcluir: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text("Nome: ${aluno.nome}")
            Text("Nota 1: ${aluno.nota1}")
            Text("Nota 2: ${aluno.nota2}")
            Text("Média: ${"%.1f".format(aluno.media)}")
            Text("Situação: ${aluno.situacao.descricao}")

            Button(
                onClick = onExcluir
            ) {
                Text("Excluir")
            }
        }
    }
}