package kval_otbor.db

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

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

    fun getAllPositions():List<String>  {
        return transaction {
            Position.selectAll().map { it[Position.title] }
        }
    }

    fun getAllPositionsForDepartment(): List<String> {
        return transaction {
            Department.selectAll().map { it[Department.name] }
        }
    }

//    fun getAllPositionsFor

    fun saveEmployee(employee: Employee) {
        transaction {
            addLogger(StdOutSqlLogger)

            Employee.insert {
                it[fullName] = employee.fullName
                it[email] = employee.email
                it[phone] = employee.phone
                it[birthday] = employee.birthday
                it[positionId] = employee.positionId
                it[departmentId] = employee.departmentId
                it[managerId] = employee.managerId
                it[dismissalDate] = employee.dismissalDate
            }
        }
    }
}