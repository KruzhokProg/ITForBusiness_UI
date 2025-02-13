package kval_otbor.drop_down_menu.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DropDownMenuViewModel: ViewModel() {

    var state by mutableStateOf(DropDownState())
        private set

    init {
        state = state.copy(items = listOf("Программист", "Аналитик", "Тестировщик", "Дизайнер"))
    }

    fun onAction(action: DropDownAction) {
        when(action) {
            is DropDownAction.SwapExpanded -> state = state.copy(isExpanded = !state.isExpanded)
            is DropDownAction.ResetExpanded -> state = state.copy(isExpanded = false)
            is DropDownAction.SetSelectedText -> state = state.copy(selectedText = action.text)
        }
    }
//
//    fun swapIsExpanded() {
//        state = state.copy(isExpanded = !state.isExpanded)
//    }
//
//    fun resetIsExpanded() {
//        state = state.copy(isExpanded = false)
//    }
//
//    fun setSelectedText(text: String) {
//        state = state.copy(selectedText = text)
//    }
}