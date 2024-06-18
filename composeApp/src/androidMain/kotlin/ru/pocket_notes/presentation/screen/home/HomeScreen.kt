package ru.pocket_notes.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import ru.pocket_notes.domain.entities.Note
import ru.pocket_notes.domain.states.RequestState
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
            Column(modifier= Modifier
                .fillMaxSize()
                .padding(top = 24.dp)
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()
                )
            ) {}
        }
    }

    @Composable
    fun DisplayNotes(
        modifier: Modifier = Modifier,
        notes: RequestState<List<Note>>,
        onSelect: ((Note) -> Unit)? = null,
        onDelete: ((Note) -> Unit)? = null
    ){
        var showDialogToDelete by remember { mutableStateOf(false) }
        var noteToDelete: Note? by remember { mutableStateOf(null) }

        if(showDialogToDelete){
            AlertDialog(
                title = {Text(text="Удаление")},
                text = {Text(text="Уверен, что хочешь удалить заметку?")},
                confirmButton = {
                                Button(
                                    onClick={
                                        onDelete?.invoke(noteToDelete!!)
                                        showDialogToDelete = false
                                        noteToDelete = null
                                    }
                                ){
                                    Text(text = "Да")
                                }
                },
                dismissButton = {
                    TextButton(
                        onClick={
                            noteToDelete = null
                            showDialogToDelete = false
                        }
                    ){
                        Text(text = "отмена")
                    }
                },
                onDismissRequest = {
                    noteToDelete = null
                    showDialogToDelete = false
                },
            )

        }
    }

}