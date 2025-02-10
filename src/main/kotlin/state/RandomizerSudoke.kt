package state

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.random.Random

@Composable
@Preview
fun App() {
     val numbers = (1..9).map { Random.nextInt(0, 9) }
    ImagesDemo(numbers)
}
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

@Composable
fun ImagesDemo(valueOfBoxes: List<Int>) {
    val guessState: MutableState<String> = remember { mutableStateOf(String()) }
    var counter = 0

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(100.dp))
        TextField(
            value = guessState.value,
            onValueChange = {guessState.value = it},
            label = { Text("Введите сумму которую надо достичь") },
            modifier = Modifier.height(50.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            modifier = Modifier.height(50.dp),
            onClick = {
                val guessNumber = guessState.value.toInt()
                if (valueOfBoxes[0] + valueOfBoxes[3] + valueOfBoxes[6] == guessNumber) {

                }
                else if (valueOfBoxes[1] + valueOfBoxes[4] + valueOfBoxes[7] == guessNumber) {

                }
                else if (valueOfBoxes[2] + valueOfBoxes[5] + valueOfBoxes[8] == guessNumber) {

                }
                else if (valueOfBoxes[0] + valueOfBoxes[4] + valueOfBoxes[8] == guessNumber) {

                }
                else if (valueOfBoxes[0] + valueOfBoxes[1] + valueOfBoxes[2] == guessNumber) {

                }
                else if (valueOfBoxes[2] + valueOfBoxes[4] + valueOfBoxes[6] == guessNumber) {

                }
                else if (valueOfBoxes[3] + valueOfBoxes[4] + valueOfBoxes[5] == guessNumber) {

                }
                else if (valueOfBoxes[6] + valueOfBoxes[7] + valueOfBoxes[8] == guessNumber) {

                }
                else {

                }
            }
        ) {
            Text("Проверка")
        }
        Column(modifier = Modifier.fillMaxSize()) {
            for (i in 0..2) {
                Row(modifier = Modifier.fillMaxSize().weight(1f)) {
                    for (i1 in 0..2) {
                        Box(modifier = Modifier
                            .fillMaxSize().weight(1f)
                            .border(border = BorderStroke(1.dp, color = Color.Black))
                            .align(alignment = Alignment.CenterVertically)
                        )
                        {
                            Text(
                                text = valueOfBoxes[counter].toString(),
                                modifier = Modifier.fillMaxSize(),
                            )
                        }
                        counter += 1
                    }
                }
            }
        }
    }
}
