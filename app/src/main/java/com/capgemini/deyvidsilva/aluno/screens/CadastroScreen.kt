package com.capgemini.deyvidsilva.aluno.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.capgemini.deyvidsilva.aluno.navigation.NavRoutes
import com.capgemini.deyvidsilva.aluno.ui.components.AlunoCard
import com.capgemini.deyvidsilva.aluno.ui.components.DefaultButton
import com.capgemini.deyvidsilva.aluno.ui.components.NomeTextField
import com.capgemini.deyvidsilva.aluno.ui.components.NotaTextField
import com.capgemini.deyvidsilva.aluno.viewmodel.AlunoViewModel

@Composable
fun CadastroScreen(
    navController: NavHostController,
    viewModel: AlunoViewModel
) {

    val context = LocalContext.current

    var nome by remember { mutableStateOf("") }
    var nota1 by remember { mutableStateOf("") }
    var nota2 by remember { mutableStateOf("") }

    val alunos by viewModel.alunos.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Cadastro de Alunos",
            style = MaterialTheme.typography.headlineSmall
        )

        NomeTextField(
            value = nome,
            onValueChange = { nome = it }
        )

        NotaTextField(
            label = "Nota 1",
            value = nota1,
            onValueChange = { nota1 = it }
        )

        NotaTextField(
            label = "Nota 2",
            value = nota2,
            onValueChange = { nota2 = it }
        )

        DefaultButton(
            text = "Cadastrar"
        ) {

            val n1 = nota1.toDoubleOrNull()
            val n2 = nota2.toDoubleOrNull()

            when {

                nome.isBlank() -> {
                    Toast.makeText(
                        context,
                        "Informe o nome do aluno.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                n1 == null || n2 == null -> {
                    Toast.makeText(
                        context,
                        "Digite notas válidas.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                n1 !in 0.0..10.0 || n2 !in 0.0..10.0 -> {
                    Toast.makeText(
                        context,
                        "As notas devem estar entre 0 e 10.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {

                    viewModel.adicionarAluno(
                        nome = nome,
                        nota1 = n1,
                        nota2 = n2
                    )

                    Toast.makeText(
                        context,
                        "Aluno cadastrado com sucesso!",
                        Toast.LENGTH_SHORT
                    ).show()

                    nome = ""
                    nota1 = ""
                    nota2 = ""
                }
            }
        }

        DefaultButton(
            text = "Ver Resumo"
        ) {
            navController.navigate(NavRoutes.RESUMO)
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            items(
                items = alunos,
                key = { it.id }
            ) { aluno ->

                AlunoCard(
                    aluno = aluno,
                    onExcluir = {
                        viewModel.removerAluno(aluno.id)

                        Toast.makeText(
                            context,
                            "Aluno removido.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )

            }

        }

    }

}