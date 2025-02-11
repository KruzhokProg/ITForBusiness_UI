package kval_otbor

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun DatePicker(
    imageVector: ImageVector
) {

    val date = remember { mutableStateOf("") }

    BasicTextField(
        value = date.value,
        onValueChange = { },
        decorationBox = { innerBox ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().border(1.dp, Color.Black),
            ) {
                if (date.value.isEmpty()) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "дд.мм.гггг"
                    )
                } else {
                    innerBox()
                }
                IconButton(
                    modifier = Modifier.padding(5.dp).size(24.dp),
                    onClick = {}
                ) {
                    Icon(
                        imageVector = imageVector,
                        contentDescription = null
                    )
                }
            }
        }
    )
}