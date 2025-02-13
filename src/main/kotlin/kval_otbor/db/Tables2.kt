package kval_otbor.db

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Staff: Table() {
    val staffId: Column<Int> = integer("staff_id")
    val dateIn: Column<LocalDateTime> = datetime("date_in")
    val dateOut: Column<LocalDateTime> = datetime("date_out")

    override val primaryKey = PrimaryKey(staffId)
}

object Guest: Table() {
    val guestId: Column<Int> = integer("guest_id")
    override val primaryKey = PrimaryKey(guestId)
    val fullName: Column<String> = varchar("full_name", 255)
    val email: Column<String> = varchar("email", 255)
    val phone: Column<String> = varchar("phone", 16)
    val passwordNumber: Column<Int> = integer("password_number")
}

object Category: Table() {
    val categoryId: Column<Int> = integer("category_id")
    val name: Column<String> = varchar("name", 255)

    override val primaryKey = PrimaryKey(categoryId)
}

object Status: Table() {
    val statusId: Column<Int> = integer("status_id")
    val statusName: Column<String> = varchar("status_name", 255)

    override val primaryKey = PrimaryKey(statusId)
}

object Room: Table() {
    val roomId: Column<Int> = integer("room_id")
    val roomNumber: Column<Int> = integer("room_number")
    val roomCategory: Column<Int> = integer("room_category") references Category.categoryId
    val statusId: Column<Int> = integer("status_id") references Status.statusId
    val pricePerNight: Column<Int> = integer("price_per_night")

    override val primaryKey = PrimaryKey(roomId)
}

object Book: Table() {
    val bookingId: Column<Int> = integer("book_id")
    val guestId: Column<Int> = integer("guest_id") references Guest.guestId
    val roomId: Column<Int> = integer("room_id") references Room.roomId
    val checkInDate: Column<LocalDateTime> = datetime("check_in_date")
    val checkOutDate: Column<LocalDateTime> = datetime("check_out_date")
    val totalPrice: Column<Int> = integer("total_price")
    val status: Column<String> = varchar("status", 255)

    override val primaryKey = PrimaryKey(bookingId)
}

object Payment: Table() {
    val paymentId: Column<Int> = integer("payment_id")
    val bookingId: Column<Int> = integer("booking_id") references Book.bookingId
    val paymentDate: Column<LocalDateTime> = datetime("payment_date")
    val amount: Column<Int> = integer("amount")
    val paymentTipe: Column<String> = varchar("payment_time", 255)

    override val primaryKey = PrimaryKey(paymentId)
}

object Clean: Table() {
    val cleaningId: Column<Int> = integer("cleaning_id")
    val roomId: Column<Int> = integer("room_id") references Room.roomId
    val staffId: Column<Int> = integer("staff_id") references Staff.staffId
    val cleaningDate: Column<LocalDateTime> = datetime("cleaning_date")
    val status: Column<String> = varchar("status", 255)

    override val primaryKey = PrimaryKey(cleaningId)
}