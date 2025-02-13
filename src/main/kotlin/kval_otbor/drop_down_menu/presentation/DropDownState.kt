package kval_otbor.drop_down_menu.presentation

data class DropDownState(
    val isExpanded: Boolean = false,
    val selectedText: String = "",
    val items: List<String> = emptyList()
)