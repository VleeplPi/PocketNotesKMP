package ru.pocket_notes.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.pocket_notes.presentation.theme.largePadding

@Composable
fun ErrorMessage(message: String? = null){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(largePadding),
        contentAlignment = Alignment.Center,
    ){
        Text(message ?: "Empty")
    }
}