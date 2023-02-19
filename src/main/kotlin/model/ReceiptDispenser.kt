package model

import model.VehicleType.CAR
import java.time.LocalDateTime

class ReceiptDispenser(
    val ticket: Ticket,
    val receiptNumber: Int = ticket.ticketNumber,
    val vehicleType: VehicleType = CAR,
    val exitTime: LocalDateTime = LocalDateTime.now()
) {
    fun generateReceipt(): Receipt {
        val timeCalculator = TimeCalculator(
            entryTime = ticket.entryTime,
            exitTime = exitTime
        )
        return Receipt(
            receiptNumber = receiptNumber,
            parkedDuration = timeCalculator.calculateParkedDuration(),
            fee = FeeCalculator().calculate(timeCalculator.convertToHours()),
            vehicleType = vehicleType,
            entryTime = ticket.entryTime,
            exitTime = exitTime
        )
    }
}
