package ru.pocket_notes.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import ru.pocket_notes.presentation.theme.componentShapes

class HomeScreen: Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content(){
        Scaffold(topBar = {
            CenterAlignedTopAppBar(title = { "Hello" })
        },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {},
                    shape= componentShapes.medium
                )
                {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "add pocket notes")
                }
            }
        ){padding ->
            Column(modifier=Modifier
                .fillMaxSize()
                .padding(top=24.dp)
                .padding(top=padding.calculateTopPadding(), bottom = padding.calculateBottomPadding())
            ) {}
        }
    }

}