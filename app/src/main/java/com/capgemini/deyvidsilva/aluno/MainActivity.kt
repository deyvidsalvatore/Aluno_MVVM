package com.capgemini.deyvidsilva.aluno

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.capgemini.deyvidsilva.aluno.ui.theme.AlunoMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlunoMVVMTheme {
            }
        }
    }
}