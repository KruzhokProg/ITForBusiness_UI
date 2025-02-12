package kval_otbor

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(
    items: List<String> = listOf("Программист", "Аналитик", "Тестировщик", "Дизайнер")
) {
    val list = remember { items }
    var isExpanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(list[0]) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(
            modifier = Modifier,
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }
        ) {
            BasicTextField(
                modifier = Modifier.menuAnchor(),
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                decorationBox = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.border(width = 1.dp, color = Color.Black)
                    ) {
                        Text(
                            modifier = Modifier.weight(1f).padding(horizontal = 5.dp),
                            text = selectedText
                        )
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                    }
                }
            )
            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                list.forEach { text ->
                    DropdownMenuItem(
                        text = { Text(text = text) },
                        onClick = {
                            selectedText = text
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}