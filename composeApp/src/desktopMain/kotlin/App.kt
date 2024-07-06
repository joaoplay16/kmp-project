import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import data.local.DataStoreSingleton
import data.local.PreferencesDataStore
import org.jetbrains.compose.ui.tooling.preview.Preview
import screen.HomeScreen
import ui.theme.KmpProjectTheme
import viewmodel.ConfigurationViewModel

@Composable
@Preview
fun App() {
    val preferencesDataStore = PreferencesDataStore(DataStoreSingleton.getDataStoreInstance())
    val configViewModel: ConfigurationViewModel = viewModel { ConfigurationViewModel(preferencesDataStore) }
    val darkTheme = configViewModel.darkTheme.value

    KmpProjectTheme(darkTheme = darkTheme) {
        Surface {
            Navigator(HomeScreen(preferencesDataStore)) { navigator ->
                SlideTransition(navigator)
            }
        }
    }
}