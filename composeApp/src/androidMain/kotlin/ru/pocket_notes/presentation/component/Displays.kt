package ru.pocket_notes.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ru.pocket_notes.domain.entities.PocketCard
import ru.pocket_notes.domain.states.RequestState

@Composable
fun DisplayPocketCards(
    modifier: Modifier = Modifier,
    pocketCard: RequestState<List<PocketCard>>,
    onSelect: ((PocketCard) -> Unit)? = null,
    onDelete: ((PocketCard) -> Unit)? = null
){
    var showDialog = remember {mutableStateOf(false)}
    var cardToDelete: PocketCard? by remember {mutableStateOf(null)}
    TODO("ADDED LOGIC FOR DISPLAY POCKET CARD")

}