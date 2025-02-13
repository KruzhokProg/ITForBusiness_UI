package kval_otbor.date_picker

sealed interface DatePickerAction {
    object ShowDialog: DatePickerAction
    class SelectDate: DatePickerAction
    object ShowDialogfalse: DatePickerAction
    class Mil: DatePickerAction
    class Formatter: DatePickerAction
}