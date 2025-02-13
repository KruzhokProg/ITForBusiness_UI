package kval_otbor.date_picker

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class DatePickerViewModel : ViewModel () {
    var state by mutableStateOf(DatePickerStateNotKt())
        private set

    @OptIn(ExperimentalMaterial3Api::class)
    fun OnAction(action: DatePickerAction){
        when (action){
            is DatePickerAction.ShowDialog -> state = state.copy(showDialog = true)
            is DatePickerAction.SelectDate -> state = state.copy(selectedDate = selectedDate)
            is DatePickerAction.ShowDialogfalse -> state = state.copy(showDialog = false)
            is DatePickerAction.Mil -> state = state.copy()
            is DatePickerAction.Formatter -> state = state.copy(formatter = convertMillisToDate())//formatter(Date(millis)))
        }
    }

    fun convertMillisToDate(millis: Long): String {
        val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        return formatter.format(Date(millis))
    }
}