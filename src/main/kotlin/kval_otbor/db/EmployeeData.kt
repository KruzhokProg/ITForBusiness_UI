package kval_otbor.db

import kotlinx.datetime.LocalDateTime
import kval_otbor.db.Employee.autoIncrement
import kval_otbor.db.Employee.nullable
import kval_otbor.db.Employee.references
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

data class EmployeeInfo(
    val employeeId: Int,
    val fullName: String,
    val email: String,
    val phone: String,
    val birthday: LocalDateTime,
    val positionId: Int,
    val departmentId: Int,
    val managerId: Int?,
    val dismissalDate: LocalDateTime?,
    val fired: Boolean
)
