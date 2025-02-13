package kval_otbor.db

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseUtils {

    fun connect() {
        Database.connect("jdbc:postgresql://localhost:5432/postgres", "org.postgresql.Driver", user = "postgres", password = "")
    }

    fun createTables() {
        transaction {
            SchemaUtils.create(Department, Position, Employee, Training, Calendar, Absence)
        }
    }
}