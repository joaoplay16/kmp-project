package screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlin.random.Random

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart,
        ) {
            Features(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                navigator = navigator
            )
        }
    }

    @Composable
    fun Features(
        modifier: Modifier = Modifier,
        navigator: Navigator
    ) {
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Adaptive(200.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Button(onClick = {
                    navigator.push(
                        DetailsScreen(Random.nextInt(0, 100))
                    )
                }) {
                    Text(text = "Go to details", color = MaterialTheme.colors.onPrimary)
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        ScrollableListScreen()
                    )
                }) {
                    Text(text = "ScrollableList", color = MaterialTheme.colors.onPrimary)
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        ScrollableLazyListScreen()
                    )
                }) {
                    Text(text = "ScrollableLazyListScreen", color = MaterialTheme.colors.onPrimary)
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        ClickEventScreen()
                    )
                }) {
                    Text(text = "ClickEventScreen", color = MaterialTheme.colors.onPrimary)
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        ContextMenuScreen()
                    )
                }) {
                    Text(text = "ContextMenuScreen", color = MaterialTheme.colors.onPrimary)
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        DraggableScreen()
                    )
                }) {
                    Text(text = "DraggableScreen", color = MaterialTheme.colors.onPrimary)
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        KeyEventScreen()
                    )
                }) {
                    Text(text = "KeyEventScreen", color = MaterialTheme.colors.onPrimary)
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        MouseHoverScreen()
                    )
                }) {
                    Text(text = "MouseHoverScreen", color = MaterialTheme.colors.onPrimary)
                }
            }
            item {
                Button(onClick = {
                    navigator.push(
                        TooltipsScreen()
                    )
                }) {
                    Text(text = "TooltipsScreen", color = MaterialTheme.colors.onPrimary)
                }
            }
        }
    }
}