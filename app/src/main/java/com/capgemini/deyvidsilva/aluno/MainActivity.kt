package com.capgemini.deyvidsilva.aluno

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.capgemini.deyvidsilva.aluno.navigation.NavGraph
import com.capgemini.deyvidsilva.aluno.ui.theme.AlunoMVVMTheme
import com.capgemini.deyvidsilva.aluno.viewmodel.AlunoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val alunoViewModel: AlunoViewModel = viewModel()

            AlunoMVVMTheme {
                NavGraph(
                    navController = navController,
                    viewModel = alunoViewModel
                )
            }
        }
    }
}