package schema

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.math.ceil

var RECEIPT_NUMBER = 0

class Receipt(
    private var exitDate: LocalDateTime = LocalDateTime.now(),
    private var receiptNumber: Int = ++RECEIPT_NUMBER,
    private var location: Mall = Mall(),
    private var ticket: Ticket
) {
    private var fee: Int = 0

    init {
        fee = this.location.calculateFee(ticket.getVehicle(), calculateParkedDuration(ticket)).toInt()
    }

    fun generateReceipt(): String {
        return "Parking Receipt:\n\t" +
                "Receipt Number:\t$receiptNumber\n\t" +
                "Entry Date:\t${ticket.getEntryDate()}\n\t" +
                "Exit Date:\t${exitDate.withNano(0).toLocalTime()}\n\t" +
                "Fees:\t$fee\n\t"
    }

    private fun calculateParkedDuration(ticket: Ticket): Long {
        val minute = exitDate.minus(ticket.getEntryDate().minute.toLong(), ChronoUnit.MINUTES).minute.toDouble()
        val hours = exitDate.minus(ticket.getEntryDate().hour.toLong(), ChronoUnit.HOURS).hour.toDouble()
        return ceil(hours + (minute / 60)).toLong()
    }
}