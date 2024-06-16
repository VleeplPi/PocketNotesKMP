import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.example.compose.PocketNotesAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.pocket_notes.presentation.screen.home.HomeScreen

@Composable
@Preview
fun App() {
    PocketNotesAppTheme {
        Navigator(HomeScreen()){
            SlideTransition(it)
        }

    }
}