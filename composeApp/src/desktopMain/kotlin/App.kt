import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import ui.theme.KmpProjectTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import screen.HomeScreen

@Composable
@Preview
fun App() {
    KmpProjectTheme(darkTheme = true) {
        Surface {
            Navigator(HomeScreen()) { navigator ->
                SlideTransition(navigator)
            }
        }
    }
}