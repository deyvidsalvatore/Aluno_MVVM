package com.capgemini.deyvidsilva.aluno.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.capgemini.deyvidsilva.aluno.ui.components.DefaultButton
import com.capgemini.deyvidsilva.aluno.ui.components.ResumoCard
import com.capgemini.deyvidsilva.aluno.viewmodel.AlunoViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResumoScreen(
    navController: NavHostController,
    viewModel: AlunoViewModel
) {

    val alunos by viewModel.alunos.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Resumo",
            style = MaterialTheme.typography.headlineSmall
        )

        ResumoCard(
            titulo = "Aprovados",
            quantidade = viewModel.aprovados
        )

        ResumoCard(
            titulo = "Em Recuperação",
            quantidade = viewModel.recuperacao
        )

        ResumoCard(
            titulo = "Reprovados",
            quantidade = viewModel.reprovados
        )

        ResumoCard(
            titulo = "Total de Alunos",
            quantidade = alunos.size
        )

        DefaultButton(
            text = "Voltar"
        ) {
            navController.popBackStack()
        }

    }

}