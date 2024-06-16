package screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen

class MouseHoverScreen : Screen {
    @Composable
    override fun Content(){
        MouseHoverContent()
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
}