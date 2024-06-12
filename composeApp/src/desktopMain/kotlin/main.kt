import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import api.ApiService
import kotlinx.coroutines.launch

fun main() = application {

    var secondWindowOpened by remember { mutableStateOf(true) }
    var apiResponse by remember { mutableStateOf("Waiting...")}
    val scope = rememberCoroutineScope()

    Window(
        onCloseRequest = ::exitApplication,
        title = "KmpProject",
    ) {
        App()
        if (secondWindowOpened) {
            Window(
                onCloseRequest = { secondWindowOpened = false },
                title = "Second Window",
                state = WindowState(width = 600.dp, height = 600.dp),
                resizable = false
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {
                        scope.launch{
                            apiResponse = ApiService().fetchData()
                        }
                    }) {
                        Text("Click me")
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(text = apiResponse)
                }
            }
        }
    }
}