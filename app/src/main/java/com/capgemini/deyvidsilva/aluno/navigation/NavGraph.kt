package com.capgemini.deyvidsilva.aluno.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.capgemini.deyvidsilva.aluno.viewmodel.AlunoViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: AlunoViewModel
) {

    NavHost(
        navController = navController,
        startDestination = NavRoutes.CADASTRO
    ) {

        composable(NavRoutes.CADASTRO) {

//            CadastroScreen(
//                navController = navController,
//                viewModel = viewModel
//            )

        }

        composable(NavRoutes.RESUMO) {
//
//            ResumoScreen(
//                navController = navController,
//                viewModel = viewModel
//            )

        }

    }

}