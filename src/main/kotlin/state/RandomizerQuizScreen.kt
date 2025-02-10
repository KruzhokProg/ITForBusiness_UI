package state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun RandomizerQuizScreen() {
    val randomNumber = remember { mutableStateOf(Random.nextInt(1, 100)) }
    val attempts = remember { mutableStateOf(0) }
    val guessState: MutableState<NumberGuessState> = remember { mutableStateOf(NumberGuessState()) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        TextField(
            value = guessState.value.numberText,
            onValueChange = { newText ->
                guessState.value = guessState.value.copy(numberText = newText)
            }
        )
        Button(
            onClick = {
                val guessNumber = guessState.value.numberText.toIntOrNull()
                if (guessNumber != null) {
                    attempts.value++
                }

                guessState.value = guessState.value.copy(
                    guessText = when {
                        guessNumber == null -> "Пожалуйста введите число!"

                        guessNumber > randomNumber.value -> "Нет, загаданное число меньше"

                        guessNumber < randomNumber.value -> "Нет, загаданное число больше"

                        else -> "Да! Всё верно! Загаданное число: ${randomNumber.value} Число попыток: ${attempts.value}"
                    },
                    isGuessCorrect = guessNumber == randomNumber.value,
                    numberText = ""
                )
            }
        ) {
            Text("Make guess")
        }
        guessState.value.guessText?.let {
            Text(
                text = it
            )
        }
        if (guessState.value.isGuessCorrect) {
            Button(
                onClick = {
                    randomNumber.value = Random.nextInt(1, 100)
                    guessState.value = guessState.value.copy(
                        numberText = "",
                        guessText = null,
                        isGuessCorrect = false
                    )
                }
            ) {
                Text("Start new game")
            }
        }
    }
}

//ДЗ
//Ввести число для суммы: < 30 -> 11
//Нажимаешь кнопку заполнения поля рандомными числами в диапазоне [0..9] и поле ввода числа пропадает
//В случае выигрыша правильное направление закрашивается нужным цветом и появляется кнопка начала новой игры и поле ввода новой суммы
//В след игре сбрасываются цвета и генерируется новое поле
//|6|5|3|
//|2|1|6|
//|7|4|0|