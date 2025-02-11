package kval_otbor

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

data class Worker(
    val ID: Int,
    val Name: String,
    val Email: String,
    val Phone: String,
    val Employee: String,
    val SubUnit: String,
    val Main: String,
    val Stat: String
)

@Composable
fun Screen() {
    val textfieldValue = remember { mutableStateOf<String>("") }
    val checkedStateForFSTChecker = remember { mutableStateOf(true) }
    val checkedStateForSNDChecker = remember { mutableStateOf(false) }
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
                }
            )
            Text(text = "Активные")

            Checkbox(
                checked = checkedStateForSNDChecker.value,
                onCheckedChange = {
                    checkedStateForSNDChecker.value = it
                    checkedStateForFSTChecker.value = !it
                }
            )
            Text(text = "Уволенные")
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp)
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

    }
}

@Composable
fun RowScope.TableCell(
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