package kval_otbor.date_picker

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import java.text.SimpleDateFormat
import java.util.*

data class DatePickerStateNotKt @OptIn(ExperimentalMaterial3Api::class) constructor(
    val showDialog:  Boolean = false,
    val selectedDate: Long? = null,
    val datePickerState: DatePickerState? = null
)