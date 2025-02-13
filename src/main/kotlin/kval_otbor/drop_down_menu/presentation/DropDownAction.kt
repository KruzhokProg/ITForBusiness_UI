package kval_otbor.drop_down_menu.presentation

sealed interface DropDownAction {
    object SwapExpanded : DropDownAction
    object ResetExpanded : DropDownAction
    class SetSelectedText(val text: String) : DropDownAction
}

//
//interface Connected
//
//class Smartphone: Connected
//class Fridge: Connected
//
//val connectedDevices = listOf(Smartphone(), Fridge())