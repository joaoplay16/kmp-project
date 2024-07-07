package screen

import androidx.compose.foundation.ContextMenuDataProvider
import androidx.compose.foundation.ContextMenuItem
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import components.NavigationControls

class ContextMenuScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        NavigationControls(navigator = navigator) {
            ContextMenuContent()
        }
    }

    @Composable
    fun ContextMenuContent() {
        var text by remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContextMenuDataProvider(
                items = {
                    listOf(
                        ContextMenuItem(label = "Custom action") {
                            println("Custom action clicked")
                        }
                    )
                }
            ) {
                TextField(value = text, onValueChange = { text = it })
                Spacer(modifier = Modifier.height(12.dp))
                SelectionContainer {
                    Text(text = "Hello world!")
                }
            }
        }
    }
}