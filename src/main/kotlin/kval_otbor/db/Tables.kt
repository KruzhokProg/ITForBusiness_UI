package kval_otbor.db

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.`java-time`.CurrentDateTime
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object Department: Table() {
    val departmentId: Column<Int> = integer("department_id")
    override val primaryKey = PrimaryKey(departmentId)
    val name: Column<String> = varchar("name", 255)
    val parentDepartmentId : Column<Int> = integer("parent_department_id") references departmentId
}

object Position: Table() {
    val positionId : Column<Int> = integer("position_id")
    override val primaryKey = PrimaryKey(positionId)
    val title: Column<String> = varchar("title", 255)
}

object Employee : Table() {
    val employeeId: Column<Int> = integer("employee_id")
    override val primaryKey = PrimaryKey(employeeId)
    val fullName: Column<String> = varchar("full_name", 255)
    val email: Column<String> = varchar("email", 255)
    val phone: Column<String> = varchar("phone", 20)
    val birthday: Column<LocalDateTime> = datetime("birthday")
    val positionId: Column<Int> = integer("position_id") references Position.positionId
    val departmentId: Column<Int> = integer("department_id") references Department.departmentId
    val managerId: Column<Int> = integer("manager_id") references employeeId
    val dismissalDate: Column<LocalDateTime> = datetime("dismissal_date")
}

object Training: Table() {
    val trainingId: Column<Int> = integer("training_id")
    override val primaryKey = PrimaryKey(trainingId)
    val title: Column<String> = varchar("title", 255)
    val startDate: Column<LocalDateTime> = datetime("start_date")
    val endDate: Column<LocalDateTime> = datetime("end_date")
    val employee_id: Column<Int> = integer("employee_id") references Employee.employeeId
}

object Calendar: Table() {
    val date: Column<LocalDateTime> = datetime("date")
    override val primaryKey = PrimaryKey(date)
    val isWorkingDay: Column<Boolean> = bool("is_working_day")
}

object Absence: Table() {
    val absence_id: Column<Int> = integer("absence_id")
    override val primaryKey = PrimaryKey(absence_id)
    val type: Column<String> = varchar("type", 255)
    val startDate: Column<LocalDateTime> = datetime("start_date") references Calendar.date
    val endDate: Column<LocalDateTime> = datetime("end_date") references Calendar.date
    val employee_id:Column<Int> = integer("employee_id") references Employee.employeeId
}