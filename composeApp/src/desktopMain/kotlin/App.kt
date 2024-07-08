import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import components.FeatureGrid
import data.local.DataStoreSingleton
import data.local.PreferencesDataStore
import org.jetbrains.compose.ui.tooling.preview.Preview
import screen.*
import ui.theme.KmpProjectTheme
import ui.theme.components.MenuItemButton
import viewmodel.ConfigurationViewModel
import kotlin.random.Random

@Composable
@Preview
fun App() {
    val preferencesDataStore = PreferencesDataStore(DataStoreSingleton.getDataStoreInstance())
    val configViewModel: ConfigurationViewModel = viewModel { ConfigurationViewModel(preferencesDataStore) }
    val darkTheme = configViewModel.darkTheme.value

    KmpProjectTheme(darkTheme = darkTheme) {
        Surface {
            Navigator(HomeScreen(
                preferencesDataStore = preferencesDataStore,
                configViewModel = configViewModel,
                featureItems = { navigator ->
                FeatureGrid(navigator= navigator)
            })) { navigator ->
                SlideTransition(navigator)
            }
        }
    }
}