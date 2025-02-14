package kval_otbor

import Navigation.NavController
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kval_otbor.date_picker.CustomDatePicker
import kval_otbor.db.DatabaseUtils
import kval_otbor.drop_down_menu.DropDownMenu

@Composable
fun Screen(navController: NavController) {
    val textfieldValue = remember { mutableStateOf("") }
    val checkedActive = remember { mutableStateOf(true) }
    val checkedFired = remember { mutableStateOf(false) }
    val listOfButtons =
        remember { listOf("Добавить сотрудника", "Редактировать сотрудника", "Удалить сотрудника", "Эскопрт в CSV") }
    val employees = remember { DatabaseUtils.getAllEmployees() }
    val headers = remember {
        listOf(
            "ID",
            "Имя",
            "Email",
            "Телефон",
            "Должность",
            "Подразделение",
            "Руководитель",
            "Статус"
        )
    }
    Column(modifier = Modifier.fillMaxSize()) {

        Row(modifier = Modifier.fillMaxWidth()) {
            BasicTextField(
                value = textfieldValue.value,
                modifier = Modifier.align(alignment = Alignment.CenterVertically).padding(5.dp).height(22.dp)
                    .width(250.dp).border(1.dp, color = Color.Black).padding(2.dp),
                onValueChange = { textfieldValue.value = it }
            )

            Checkbox(
                checked = checkedActive.value,
                onCheckedChange = {
                    checkedActive.value = it
                    checkedFired.value = !it
                },
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )
            Text(text = "Активные", modifier = Modifier.align(alignment = Alignment.CenterVertically))

            Spacer(modifier = Modifier.width(20.dp))

            Checkbox(
                checked = checkedFired.value,
                onCheckedChange = {
                    checkedFired.value = it
                    checkedActive.value = !it
                },
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )
            Text(text = "Уволенные", modifier = Modifier.align(alignment = Alignment.CenterVertically))
        }

        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            item {
                Row(Modifier.background(Color.Gray)) {
                    headers.forEach {
                        TableCell(text = it)
                    }
                }
            }
            items(employees) { employee ->
                Row {
                    TableCell(text = employee.employeeId.toString())
                    TableCell(text = employee.fullName)
                    TableCell(text = employee.email)
                    TableCell(text = employee.phone)
                    TableCell(text = DatabaseUtils.getPositionNameById(employee.positionId))
                    TableCell(text = DatabaseUtils.getDepartmentNameById(employee.departmentId))
                    TableCell(text = employee.managerId?.let { DatabaseUtils.getManagerNameById(it) } ?: "")
                    TableCell(
                        text = if (employee.fired) {
                            "Уволен"
                        } else {
                            "Активен"
                        }
                    )
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            for (i in 0..3) {
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xff004D40),       // цвет текста
                        backgroundColor = Color.Red
                    ),     // цвет фона
                    onClick = {
                        navController.navigate(Navigation.Screen.PROFILE)
                    }
                ) {
                    Text(
                        text = listOfButtons[i],
                        modifier = Modifier,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}

@Composable
fun Screen2(navController: NavController) {
    val fullName = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    var selectedPosition by remember {
        mutableStateOf(
            DatabaseUtils.getPositionIdByTitle(
                DatabaseUtils.getAllPositions().first()
            )
        )
    }
    var selectedDepartment by remember {
        mutableStateOf(
            DatabaseUtils.getDepartmentIdByName(
                DatabaseUtils.getAllDepartments().first()
            )
        )
    }
    var selectedBirthdayMillis by remember { mutableStateOf(0L) }
    var selectedManager by remember {
        mutableStateOf(
            DatabaseUtils.getManagerIdByName(
                DatabaseUtils.getAllManagers().first()
            )
        )
    }

    Box(
        modifier = Modifier.fillMaxSize().background(color = Color.White).padding(10.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            val listOfTexts = listOf("Полное имя", "Email")
            val listOfText2 = listOf(fullName, email)
            val texts = listOf("Дата регистрации", "Должность", "Подразделение", "Руководитель")
            val icons = listOf(
                Icons.Default.DateRange,
                Icons.Default.ArrowDropDown,
                Icons.Default.ArrowDropDown,
                Icons.Default.ArrowDropDown
            )
            val save = listOf("Сохранить", "Отменить")

            DropDownMenu(
                items = DatabaseUtils.getAllPositions(),
                onSelectedText = { text ->
                    selectedPosition = DatabaseUtils.getPositionIdByTitle(text)
                }
            )
            Spacer(modifier = Modifier.height(100.dp))
            DropDownMenu(
                items = DatabaseUtils.getAllDepartments(),
                onSelectedText = { text ->
                    selectedDepartment = DatabaseUtils.getDepartmentIdByName(text)
                }
            )
            Spacer(modifier = Modifier.height(100.dp))
            DropDownMenu(
                items = DatabaseUtils.getAllManagers(),
                onSelectedText = { text ->
                    selectedManager = DatabaseUtils.getManagerIdByName(text)
                }
            )
            Spacer(modifier = Modifier.height(100.dp))
            CustomDatePicker(
                onDateSelectedInMillis = { millis ->
                    selectedBirthdayMillis = millis
                }
            )
//            DropDownMenu(
//                items = DatabaseUtils.getAllPositionsForDepartment()
//            )

            for (i in 0..listOfTexts.size - 1) {
                Text(text = listOfTexts[i])
                Spacer(modifier = Modifier.height(6.dp))
                BasicTextField(
                    value = listOfText2[i].value,
                    modifier = Modifier.height(22.dp).fillMaxWidth().border(1.dp, color = Color.Black).padding(2.dp),
                    onValueChange = { listOfText2[i].value = it })
                Spacer(modifier = Modifier.height(6.dp))
            }
            Text(text = "Телефон")
            Spacer(modifier = Modifier.height(6.dp))
            BasicTextField(
                value = phone.value,
                modifier = Modifier.height(22.dp).fillMaxWidth().border(1.dp, color = Color.Black).padding(2.dp),
                onValueChange = { phone.value = it }) {
                if (phone.value == "") {
                    Text(text = "+7 (900)123-45-67")
                } else {
                    Text(text = phone.value)
                }
            }
            for (i in 0..texts.size - 1) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = texts[i])
                Spacer(modifier = Modifier.height(6.dp))
//                CustomDatePicker(imageVector = icons[i], texts[i])
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                for (i in 0..1) {
                    Box(modifier = Modifier.background(color = Color.Red)) {
                        Button(
                            onClick = {
//                                navController.navigate(Navigation.Screen.MAIN)
                                // Сохранение в бд
                                DatabaseUtils.saveEmployee(
                                    fullName = fullName.value,
                                    email = email.value,
                                    phone = phone.value,
                                    birthday = selectedBirthdayMillis,
                                    positionId = selectedPosition.toInt(),
                                    departmentId = selectedDepartment,
                                    managerId = selectedManager.toInt(),
                                    dismissalDate = "2020-02-20T12:00:00"
                                )
                            },
                            modifier = Modifier.height(30.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color(0xff004D40),       // цвет текста
                                backgroundColor = Color.Red
                            )     // цвет фона
                        ) {
                            Text(
                                text = save[i],
                                modifier = Modifier.background(color = Color.Red),
                                color = Color.White,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }
    }
}
