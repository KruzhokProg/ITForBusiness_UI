package kval_otbor.db

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.neq
import org.jetbrains.exposed.sql.transactions.transaction
import java.text.SimpleDateFormat
import java.util.*

object DatabaseUtils {

    init {
        Database.connect("jdbc:postgresql://localhost:5432/postgres", "org.postgresql.Driver", user = "postgres", password = "wsr2025")
    }

    fun createTables() {
        transaction {
            SchemaUtils.create(Department, Position, Employee, Training, Calendar, Absence)
//            SchemaUtils.create(Guest, Room, Staff, Category, Status, Book, Payment, Clean)
        }
    }

    fun getPositionIdByTitle(title: String): Int {
        return transaction {
            Position.selectAll().where { Position.title eq title }.map { it[Position.positionId] }.firstOrNull() ?: -1
        }
    }

    fun getPositionNameById(id: Int): String {
        return transaction {
            Position.selectAll().where { Position.positionId eq id }.map { it[Position.title] }.firstOrNull() ?: ""
        }
    }

    fun getAllPositions():List<String>  {
        return transaction {
            Position.selectAll().map { it[Position.title] }
        }
    }

    fun getDepartmentIdByName(name: String): Int{
        return transaction {
            Department.selectAll().where { Department.name eq name }.map { it[Department.departmentId] }.firstOrNull()?: -1
        }
    }

    fun getDepartmentNameById(id: Int): String{
        return transaction {
            Department.selectAll().where { Department.departmentId eq id }.map { it[Department.name] }.firstOrNull()?: ""
        }
    }
    fun getAllDepartments(): List<String> {
        return transaction {
            Department.selectAll().map { it[Department.name] }
        }
    }

    fun getManagerNameById(managerId: Int): String {
        return transaction {
            Employee.selectAll().where { Employee.employeeId eq managerId }.map { it[Employee.fullName] }.firstOrNull() ?: ""
        }
    }

    fun getManagerIdByName(name: String): Int {
        return transaction {
            Employee.selectAll().where{ Employee.fullName eq name }.map { it[Employee.employeeId] }.firstOrNull() ?: -1
        }
    }

    fun getAllEmployees(): List<EmployeeInfo> {
        return transaction {
            Employee.selectAll().map {
                EmployeeInfo(
                    employeeId = it[Employee.employeeId],
                    fullName = it[Employee.fullName],
                    email = it[Employee.email],
                    phone = it[Employee.phone],
                    birthday = it[Employee.birthday],
                    positionId = it[Employee.positionId],
                    departmentId = it[Employee.departmentId],
                    managerId = it[Employee.managerId],
                    dismissalDate = it[Employee.dismissalDate],
                    fired = it[Employee.dismissalDate] != null
                )
            }
        }
    }

    fun getAllManagers(): List<String> {
        return transaction {
//            val employees = Employee.selectAll().where { Employee.managerId eq null }
            val employeeIds = Employee.selectAll().map { it[Employee.employeeId] }
            val managerIds = Employee.selectAll().map { it[Employee.managerId] }
            val managerList = mutableSetOf<Int>()
            managerIds.forEach { managerId ->
                employeeIds.forEach { employeeId ->
                    if (employeeId == managerId) {
                        managerList.add(managerId)
                    }
                }
            }
            managerList.map { managerId -> getManagerNameById(managerId) }
//            employeeIds.map { it.toString() }
//            val ids = employees.map { it[Employee.employeeId] }
//            ids.forEach { managerId ->
//                ids.forEach { emplyeeId ->
//                }
//            }
//        }
        }
    }

    fun saveEmployee(
        fullName: String,
        email: String,
        phone: String,
        birthday: Long,
        positionId: Int,
        departmentId: Int,
        managerId: Int,
        dismissalDate: String
    ) {
        transaction {
            addLogger(StdOutSqlLogger)

            Employee.insert {
                it[this.fullName] = fullName
                it[this.email] = email
                it[this.phone] = phone
                it[this.birthday] = LocalDateTime.parse(convertMillisToDate(birthday))
                it[this.positionId] = positionId
                it[this.departmentId] = departmentId
                it[this.managerId] = managerId
                it[this.dismissalDate] = LocalDateTime.parse(dismissalDate)
            }
        }
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val tmp = formatter.format(Date(millis)) + "T12:00:00"
    return tmp
}