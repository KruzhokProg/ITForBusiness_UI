package kval_otbor.date_picker

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CustomDatePicker() {
    val viewModel = viewModel<DatePickerViewModel>()
    val state = viewModel.state

    BasicTextField(
        value = if (state.selectedDate != null) {
            convertMillisToDate(state.selectedDate!!)
        } else {
            "дд.мм.гггг"
        },
        onValueChange = { },
        decorationBox = { innerBox ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().border(1.dp, Color.Black),
            ) {
                innerBox()
                IconButton(
                    modifier = Modifier.padding(5.dp).size(24.dp),
                    onClick = {
                        viewModel.OnAction(DatePickerAction.ShowDialog)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null
                    )
                }
            }
        }
    )
    if (state.showDialog) {
        DatePickerModal(
            state = state,
            onDateSelected = { millis ->
                selected.value = millis
            },
            onDismiss = {
                viewModel.OnAction(DatePickerAction.ShowDialogfalse)
            }
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    state: DatePickerStateNotKt,
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(
                onClick = {
                    onDateSelected(state.datePickerState?.selectedDateMillis)
                    onDismiss()
                }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss
            ) {
                Text("Cancel")
            }
        }
    ) {
        state.datePickerState?.let { DatePicker(state = it) }
    }
}
