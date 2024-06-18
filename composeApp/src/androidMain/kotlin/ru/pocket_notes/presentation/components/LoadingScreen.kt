package ru.pocket_notes.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.pocket_notes.presentation.theme.largePadding

@Composable
fun LoadingScreen(modifier: Modifier = Modifier){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = largePadding),
        contentAlignment = Alignment.Center,
    ){
        CircularProgressIndicator(modifier = Modifier.size(28.dp))
    }
}