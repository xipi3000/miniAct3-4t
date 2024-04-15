package com.example.miniact3


import ImageScreenViewModel
import TextScreenUiState
import TextScreenViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.miniact3.ui.theme.ImageScreen
import com.example.miniact3.ui.theme.TextScreen
import com.example.miniact3.ui.theme.Miniact3Theme


class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Miniact3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val textScreenViewModel: TextScreenViewModel = viewModel()
    val imageScreenViewModel : ImageScreenViewModel = viewModel()
    Column {
        TextScreen(textScreenUiState = textScreenViewModel.textScreenUiState, modifier = Modifier.weight(1f))
        ImageScreen(imageScreenUiState = imageScreenViewModel.imageScreenUiState, modifier = Modifier.weight(1f))
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Miniact3Theme {
        MainScreen()
    }
}