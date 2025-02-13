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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.datetime.LocalDateTime
import kval_otbor.db.DatabaseUtils
import kval_otbor.db.Employee
import kval_otbor.drop_down_menu.DropDownMenu

@Composable
fun Screen(navController: NavController) {
    val textfieldValue = remember { mutableStateOf("") }
    val checkedStateForFSTChecker = remember { mutableStateOf(true) }
    val checkedStateForSNDChecker = remember { mutableStateOf(false) }
    val listOfButtons = remember { listOf("Добавить сотрудника", "Редактировать сотрудника", "Удалить сотрудника", "Эскопрт в CSV") }
    val worker1 = Worker(
        1,
        "Иван Иванов",
        "ivanov@example.com",
        "+7 (900) 123-45-67",
        "Разработчик",
        "ИТ-отдел",
        "Петров Петр",
        "Активен"
    )
    val worker2 = Worker(
        2,
        "Мария Смирнова",
        "smirnova@example.com",
        "+7 (901) 234-56-78",
        "Аналитик",
        "Бизнес-аналитик",
        "Сидоров Иван",
        "Активен"
    )
    val worker3 = Worker(
        3,
        "Алексей Кузнецов",
        "kuznetsov@example.com",
        "+7 (902) 345-67-89",
        "Тестировщик",
        "Контроль качества",
        "Иванов Иван",
        "Уволен"
    )
    val worker4 = Worker(
        4,
        "Ольга ВАсильева",
        "vasilieva@example.com",
        "+7 (903) 456-78-90",
        "Менеджер",
        "Продажи",
        "Сергей Волков",
        "Активен"
    )
    val listOfVar = remember {
        listOf(
            "ID",
            "Name",
            "Email",
            "Phone",
            "Employee",
            "SubUnit",
            "Main",
            "Stat"
        )
    }
    val employees = remember { listOf(worker1, worker2, worker3, worker4) }
    Column(modifier = Modifier.fillMaxSize()) {

        Row(modifier = Modifier.fillMaxWidth()) {
            BasicTextField(
                value = textfieldValue.value, modifier = Modifier.align(alignment = Alignment.CenterVertically).padding(5.dp).height(22.dp).width(250.dp).border(1.dp, color = Color.Black).padding(2.dp), onValueChange = { textfieldValue.value = it }
            )

            Checkbox(
                checked = checkedStateForFSTChecker.value,
                onCheckedChange = {
                    checkedStateForFSTChecker.value = it
                    checkedStateForSNDChecker.value = !it
                },
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )
            Text(text = "Активные", modifier = Modifier.align(alignment = Alignment.CenterVertically))

            Spacer(modifier = Modifier.width(20.dp))

            Checkbox(
                checked = checkedStateForSNDChecker.value,
                onCheckedChange = {
                    checkedStateForSNDChecker.value = it
                    checkedStateForFSTChecker.value = !it
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
                    listOfVar.forEach {
                        TableCell(text = it)
                    }
                }
            }
            items(employees) { employee ->
                Row {
                    TableCell(text = employee.ID.toString())
                    TableCell(text = employee.Name)
                    TableCell(text = employee.Email)
                    TableCell(text = employee.Phone)
                    TableCell(text = employee.Employee)
                    TableCell(text = employee.SubUnit)
                    TableCell(text = employee.Main)
                    TableCell(text = employee.Stat)
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            for (i in 0..3) {
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xff004D40),       // цвет текста
                        backgroundColor = Color.Red),     // цвет фона
                    onClick = {
                        navController.navigate(Navigation.Screen.PROFILE)
                    }
                ) {
                    Text(text = listOfButtons[i], modifier = Modifier, overflow = TextOverflow.Ellipsis, maxLines = 1, color = Color.White)
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

    Box(
        modifier = Modifier.fillMaxSize().background(color = Color.White).padding(10.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            val listOfTexts = listOf("Полное имя", "Email")
            val listOfText2 = listOf(fullName, email)
            val texts = listOf("Дата регистрации", "Должность", "Подразделение", "Руководитель")
            val icons = listOf(Icons.Default.DateRange, Icons.Default.ArrowDropDown, Icons.Default.ArrowDropDown, Icons.Default.ArrowDropDown)
            val save = listOf("Сохранить", "Отменить")

            DropDownMenu(
                items = DatabaseUtils.getAllPositions()
            )
            Spacer(modifier = Modifier.height(100.dp))
            DropDownMenu(
                items = DatabaseUtils.getAllPositionsForDepartment()
            )
            Spacer(modifier = Modifier.height(100.dp))
            DropDownMenu(
                items = DatabaseUtils.getAllPositionsForDepartment()
            )

            for (i in 0..listOfTexts.size - 1) {
                Text(text = listOfTexts[i])
                Spacer(modifier = Modifier.height(6.dp))
                BasicTextField(value = listOfText2[i].value, modifier = Modifier.height(22.dp).fillMaxWidth().border(1.dp, color = Color.Black).padding(2.dp), onValueChange = { listOfText2[i].value = it })
                Spacer(modifier = Modifier.height(6.dp))
            }
            Text(text = "Телефон")
            Spacer(modifier = Modifier.height(6.dp))
            BasicTextField(value = phone.value, modifier = Modifier.height(22.dp).fillMaxWidth().border(1.dp, color = Color.Black).padding(2.dp), onValueChange = { phone.value = it }) {
                if (phone.value == "") { Text(text = "+7 (900)123-45-67") }
                else { Text(text = phone.value) }
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
//                                val newEmployee = Employee(
//                                    fullName = fullName.value,
//                                    email = email.value,
//                                    phone = phone.value,
//                                    birthday = LocalDateTime.parse("22.02.2020"),
//                                    positionId = 1
//                                )
//                                DatabaseUtils.saveEmployee(newEmployee)
                            },
                            modifier = Modifier.height(30.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color(0xff004D40),       // цвет текста
                                backgroundColor = Color.Red)     // цвет фона
                        ) {
                            Text(text = save[i], modifier = Modifier.background(color = Color.Red), color = Color.White, overflow = TextOverflow.Ellipsis,)
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }
    }
}