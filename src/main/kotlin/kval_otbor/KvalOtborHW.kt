package kval_otbor

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun KvakOtborHW() {
    val textfieldValue = remember { mutableStateOf<String>("") }
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
            TextField(
                value = textfieldValue.value,
                onValueChange = { textfieldValue.value = it },
                label = { Text(text = "Поиск по имени, должности") }
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
                        TableCell2(text = it)
                    }
                }
            }
            items(employees) { employee ->
                Row {
                    TableCell2(text = employee.ID.toString())
                    TableCell2(text = employee.Name)
                    TableCell2(text = employee.Email)
                    TableCell2(text = employee.Phone)
                    TableCell2(text = employee.Employee)
                    TableCell2(text = employee.SubUnit)
                    TableCell2(text = employee.Main)
                    TableCell2(text = employee.Stat)
                }
            }
        }
        Row {
            for (i in 0..3) {
//                Button(
//                    modifier = Modifier.width(200.dp),
//                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
//                    onClick = {}
//                ) {
//                    Text(
//                        text = listOfButtons[i],
//                        overflow = TextOverflow.Ellipsis,
//                        maxLines = 1
//                    )
//                }
                Box {
                    Text(
                        text = listOfButtons[i],
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier.clickable {  }
                            .background(Color.Yellow)
                            .padding(horizontal = 10.dp, vertical = 5.dp)

                    )
                }
            }
        }
    }
}

@Composable
fun RowScope.TableCell2(
    text: String,
) {
    Text(
        text = text,
        modifier = Modifier
            .weight(1f)
            .border(1.dp, Color.Black)
            .padding(8.dp),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}


@Composable
fun Screen2() {
    val FullName = remember { mutableStateOf("") }
    val Email = remember { mutableStateOf("") }
    val Phone = remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize().background(color = Color.White).padding(10.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            val listOfTexts = listOf("Полное имя", "Email")
            val listOfText2 = listOf(FullName, Email)
            val texts = listOf("Дата регистрации", "Должность", "Подразделение", "Руководитель")
            val icons = listOf(Icons.Default.DateRange, Icons.Default.ArrowDropDown, Icons.Default.ArrowDropDown, Icons.Default.ArrowDropDown)

            for (i in 0..listOfTexts.size - 1) {
                Text(text = listOfTexts[i])
                Spacer(modifier = Modifier.height(6.dp))
                BasicTextField(value = listOfText2[i].value, modifier = Modifier.height(22.dp).fillMaxWidth().border(1.dp, color = Color.Black).padding(2.dp), onValueChange = { listOfText2[i].value = it })
                Spacer(modifier = Modifier.height(6.dp))
            }
            Text(text = "Телефон")
            Spacer(modifier = Modifier.height(6.dp))
            BasicTextField(value = Phone.value, modifier = Modifier.height(22.dp).fillMaxWidth().border(1.dp, color = Color.Black).padding(2.dp), onValueChange = { Phone.value = it }) {
                if (Phone.value == "") { Text(text = "+7 (900)123-45-67") }
                else { Text(text = Phone.value) }
            }
            for (i in 0..texts.size - 1) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = texts[i])
                Spacer(modifier = Modifier.height(6.dp))
                DatePicker(imageVector = icons[i], texts[i])
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                for (i in 0..1) {
                    Button(
                        onClick = {},
                        modifier = Modifier.height(25.dp)
                    ) {
                        Text(text = "Сохранить", modifier = Modifier.background(color = Color.Red))
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }
    }
}

@Composable
fun DatePicker(
    imageVector: ImageVector,
    text: String
) {
    val date = remember { mutableStateOf("") }

    BasicTextField(
        value = date.value,
        onValueChange = { },
        decorationBox = { innerBox ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().border(1.dp, Color.Black).height(22.dp).padding(horizontal = 1.dp),
            ) {
                if (date.value.isEmpty()) {
                    Text(
                        modifier = Modifier.padding(horizontal = 0.5.dp),
                        text = text
                    )
                } else {
                    innerBox()
                }
                IconButton(
                    modifier = Modifier.padding(horizontal = 0.5.dp).size(24.dp),
                    onClick = {}
                ) {
                    Icon(
                        imageVector = imageVector,
                        contentDescription = null,
                    )
                }
            }
        }
    )
}