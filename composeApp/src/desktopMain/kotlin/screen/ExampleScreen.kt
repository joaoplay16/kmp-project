package screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen

class ExampleScreen : Screen {
    @Composable
    override fun Content() {
//        ScrollableList()
//        ScrollableLazyList()
//        Tooltips()
//        KeyEventContent()
//        ClickEventContent()
//        MouseHoverContent()
//        DraggableContent()
        ContextMenuContent()
    }

    @Composable
    fun ScrollableList() {
        val verticalScroll = rememberScrollState(0)
        val horizontalScroll = rememberScrollState(0)

        val scrollbarStyle = defaultScrollbarStyle().copy(
            unhoverColor = Color(0xAC683B).copy(alpha = 0.22f),
            hoverColor = Color(0xAC683B).copy(alpha = 0.50f)
        )

        Box(
            modifier = Modifier.fillMaxSize().padding(12.dp),

            ) {

            Column(
                modifier = Modifier.fillMaxSize().verticalScroll(verticalScroll).horizontalScroll(horizontalScroll)
                    .padding(end = 12.dp, bottom = 12.dp)
            ) {
                for (item in 0..30) {
                    Text(
                        modifier = Modifier.padding(bottom = 12.dp),
                        text = "This the item number #$item",
                    )
                }
            }
            VerticalScrollbar(
                modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                adapter = rememberScrollbarAdapter(verticalScroll),
                style = scrollbarStyle,
            )
            HorizontalScrollbar(
                modifier = Modifier.align(Alignment.BottomStart).padding(end = 12.dp),
                adapter = rememberScrollbarAdapter(horizontalScroll),
                style = scrollbarStyle,
            )
        }
    }

    @Composable
    fun ScrollableLazyList() {
        val horizontalScroll = rememberScrollState(0)
        val lazyListState = rememberLazyListState()

        val scrollbarStyle = defaultScrollbarStyle().copy(
            unhoverColor = Color(0xAC683B).copy(alpha = 0.22f),
            hoverColor = Color(0xAC683B).copy(alpha = 0.50f)
        )

        Box(
            modifier = Modifier.fillMaxSize().padding(12.dp),

            ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .horizontalScroll(horizontalScroll)
                    .padding(end = 12.dp, bottom = 12.dp),
                state = lazyListState
            ) {
                for (item in 0..30) {
                    item {
                        Text(
                            modifier = Modifier.padding(bottom = 12.dp),
                            text = "This the item number #$item",
                        )
                    }
                }
            }
            VerticalScrollbar(
                modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                adapter = rememberScrollbarAdapter(lazyListState),
                style = scrollbarStyle,
            )
            HorizontalScrollbar(
                modifier = Modifier.align(Alignment.BottomStart).padding(end = 12.dp),
                adapter = rememberScrollbarAdapter(horizontalScroll),
                style = scrollbarStyle,
            )
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun Tooltips() {
        val buttons = listOf("Contact us", "About")

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            buttons.forEachIndexed { index, title ->
                TooltipArea(
                    tooltip = {
                        Surface(
                            modifier = Modifier.shadow(8.dp),
                            color = Color.LightGray,
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                modifier = Modifier.padding(10.dp),
                                text = if (index == 0) " Get in touch"
                                else "This is our team",
                            )
                        }
                    },
                    delayMillis = 600,
                    tooltipPlacement = TooltipPlacement.CursorPoint(
                        alignment = BottomEnd
                    )
                ) {
                    Button(onClick = {}) {
                        Text(text = title)
                    }
                }
                if (index == 0) {
                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )
                }
            }
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

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun MouseHoverContent() {
        Column(
            modifier = Modifier.background(Color.White),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {


            repeat(10) { index ->
                var hovered by remember { mutableStateOf(false) }
                val animatedColor by animateColorAsState(
                    targetValue = if (hovered) Color.Cyan else Color.White,
                    animationSpec = tween(200)
                )

                Text(
                    modifier = Modifier
                        .background(color = animatedColor)
                        .padding(all = 8.dp)
                        .onPointerEvent(PointerEventType.Enter) { hovered = true }
                        .onPointerEvent(PointerEventType.Exit) { hovered = false },
                    fontSize = 30.sp,
                    text = "Item with the number: $index"
                )
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun DraggableContent() {
        var topBoxOffset by remember { mutableStateOf(Offset(0f, 0f)) }

        Box(
            modifier = Modifier
                .size(100.dp)
                .offset {
                    IntOffset(topBoxOffset.x.toInt(), topBoxOffset.y.toInt())
                }
                .background(Color.DarkGray)
                .pointerInput(Unit) {
                    detectDragGestures(matcher = PointerMatcher.Primary) {
                        topBoxOffset += it
                    }
                }
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Draggable",
                color = Color.White
            )
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