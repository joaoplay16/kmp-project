package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import screen.*
import ui.theme.components.MenuItemButton
import kotlin.random.Random

@Composable
fun FeatureGrid(
    modifier: Modifier = Modifier,
    navigator: Navigator,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(200.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(16.dp),

        ){
        item {
            MenuItemButton(
                onClick = {
                    navigator.push(
                        DetailsScreen(Random.nextInt(0, 100))
                    )
                },
                text = "Go to details"
            )
        }
        item {
            MenuItemButton(
                onClick = {
                    navigator.push(
                        ScrollableListScreen()
                    )
                },
                text = "ScrollableListScreen"
            )
        }
        item {
            MenuItemButton(
                onClick = {
                    navigator.push(
                        LazyListScreen()
                    )
                },
                text = "ScrollableLazyListScreen"
            )
        }
        item {
            MenuItemButton(
                onClick = {
                    navigator.push(
                        ClickEventScreen()
                    )
                },
                text = "ClickEventScreen"
            )
        }
        item {
            MenuItemButton(
                onClick = {
                    navigator.push(
                        ContextMenuScreen()
                    )
                },
                text = "ContextMenuScreen"
            )
        }
        item {
            MenuItemButton(
                onClick = {
                    navigator.push(
                        DraggableScreen()
                    )
                },
                text = "DraggableScreen"
            )
        }
        item {
            MenuItemButton(
                onClick = {
                    navigator.push(
                        KeyEventScreen()
                    )
                },
                text = "KeyEventScreen"
            )
        }
        item {
            MenuItemButton(
                onClick = {
                    navigator.push(
                        MouseHoverScreen()
                    )
                },
                text = "MouseHoverScreen"
            )
        }
        item {
            MenuItemButton(
                onClick = {
                    navigator.push(
                        TooltipsScreen()
                    )
                },
                text = "TooltipsScreen"
            )
        }
        item {
            MenuItemButton(
                onClick = {
                    navigator.push(
                        NetworkScreen()
                    )
                },
                text = "NetworkScreen"
            )
        }    }
}