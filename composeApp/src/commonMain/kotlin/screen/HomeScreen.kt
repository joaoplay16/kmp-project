package screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import components.ThemeToggleContainer
import data.local.PreferencesDataStore
import viewmodel.ConfigurationViewModel

class HomeScreen(
    private val preferencesDataStore: PreferencesDataStore,
    private val configViewModel: ConfigurationViewModel,
    private val featureItems: @Composable() (Navigator) -> Unit,
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart,
        ) {
            ThemeToggleContainer(
                onToggle = { configViewModel.toggleDarkTheme() }
            ) {
               featureItems(navigator)
            }
        }
    }
}