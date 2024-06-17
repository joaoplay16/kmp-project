import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.ui.tooling.preview.Preview
import screen.HomeScreen
import ui.theme.KmpProjectTheme
import viewmodel.ConfigurationViewModel

@Composable
@Preview
fun App() {
    val configViewModel: ConfigurationViewModel = viewModel { ConfigurationViewModel() }
    val darkTheme = configViewModel.darkTheme

    KmpProjectTheme(darkTheme = darkTheme) {
        Surface {
            Navigator(HomeScreen()) { navigator ->
                SlideTransition(navigator)
            }
        }
    }
}