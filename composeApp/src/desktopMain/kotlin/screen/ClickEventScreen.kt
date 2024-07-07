package screen

import components.NavigationControls
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class ClickEventScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        NavigationControls(navigator = navigator) {
            ClickEventContent()
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun ClickEventContent() {
        var text by remember { mutableStateOf("") }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .fillMaxWidth(0.7f)
                        .fillMaxHeight(0.2f)
                        .combinedClickable(
                            onClick = {
                                text = "OnClick"
                            },
                            onDoubleClick = {
                                text = "onDoubleClick"
                            },
                            onLongClick = {
                                text = "onLongClick"
                            }
                        )
                )
                Spacer(
                    modifier = Modifier.height(12.dp),
                )
                TextField(
                    value = text,
                    onValueChange = { text = it },
                )
            }
        }
    }
}