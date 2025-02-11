package kval_otbor

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField() {
    val text = remember { mutableStateOf("") }

    BasicTextField(
        value = text.value,
        onValueChange = { text.value = it },
        modifier = Modifier.width(200.dp).border(1.dp, Color.Black),
        decorationBox = {
            Box(
                modifier = Modifier.padding(5.dp)
            ) {
                if (text.value.isEmpty()) {
                    Text(
                        text = "Поиск по имени, должности",
                        color = Color.DarkGray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                } else {
                    it()
                }
            }
        }
    )
}