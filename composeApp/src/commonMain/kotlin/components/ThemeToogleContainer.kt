package components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.theme.KmpProjectTheme

@Composable
fun ThemeToggleContainer (
    onToggle: () -> Unit,
    composable: @Composable () -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            IconButton(
                modifier = Modifier
                    .padding(16.dp),
                onClick = onToggle,
                colors = IconButtonDefaults.filledIconButtonColors()
            ) {

                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Theme",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
        composable()
    }
}

@Preview
@Composable
fun ThemeToggleContainerPreview() {
    KmpProjectTheme {
        Surface {
            ThemeToggleContainer(
                onToggle = {},
                composable = {
                    Text("Hello Compose")
                }
            )
        }
    }
}