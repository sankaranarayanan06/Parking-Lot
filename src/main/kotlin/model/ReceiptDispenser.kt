package model

import model.VehicleType.CAR
import java.time.Duration
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class ReceiptDispenser(
    val ticket: TicketDispenser,
    val receiptNumber: Int,
    val vehicleType: VehicleType = CAR,
    val exitTime: LocalDateTime = LocalDateTime.now()
) {
    fun generateReceipt(): Receipt {
        return Receipt(
            receiptNumber = receiptNumber,
            parkedDuration = calculateParkedDuration(),
            fee = 0,
            vehicleType = vehicleType,
            entryTime = ticket.entryTime,
            exitTime = exitTime
        )
    }

    private fun calculateParkedDuration(): Duration {
        return Duration.between(ticket.entryTime, exitTime).truncatedTo(ChronoUnit.MINUTES)
    }
}
