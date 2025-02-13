package kval_otbor.drop_down_menu.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu() {
    val viewModel = viewModel<DropDownMenuViewModel>()
    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(
            modifier = Modifier,
            expanded = state.isExpanded,
            onExpandedChange = { viewModel.onAction(DropDownAction.SwapExpanded) }
        ) {
            BasicTextField(
                modifier = Modifier.menuAnchor(),
                value = state.selectedText,
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
                            text = state.selectedText
                        )
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = state.isExpanded)
                    }
                }
            )
            ExposedDropdownMenu(expanded = state.isExpanded, onDismissRequest = { viewModel.onAction(DropDownAction.ResetExpanded) }) {
                state.items.forEach { text ->
                    DropdownMenuItem(
                        text = { Text(text = text) },
                        onClick = {
                            viewModel.onAction(DropDownAction.SetSelectedText(text))
                            viewModel.onAction(DropDownAction.ResetExpanded)
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}