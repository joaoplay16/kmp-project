package screen

import components.NavigationControls
import androidx.compose.foundation.layout.*
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.*
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class KeyEventScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        NavigationControls(navigator = navigator) {
            KeyEventContent()
        }
    }

    @Composable
    fun KeyEventContent() {
        var text1 by remember { mutableStateOf("") }
        var text2 by remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = text1,
                onValueChange = { text1 = it },
                modifier = Modifier.onPreviewKeyEvent {
                    if (it.key == Key.Delete && it.type == KeyEventType.KeyDown) {
                        text1 = ""
                        true
                    } else false
                }
            )
            Spacer(
                modifier = Modifier.height(12.dp),
            )
            TextField(
                value = text2,
                onValueChange = { text2 = it },
            )
        }
    }
}