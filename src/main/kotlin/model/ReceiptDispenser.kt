package model

import model.VehicleType.CAR
import java.time.LocalDateTime

class ReceiptDispenser(
    val ticket: TicketDispenser,
    val receiptNumber: Int,
    val vehicleType: VehicleType = CAR,
    val exitTime: LocalDateTime = LocalDateTime.now()
) {
    fun generateReceipt(): Receipt {
        return Receipt(
            receiptNumber = receiptNumber,
            parkedDuration = TimeCalculator(
                entryTime = ticket.entryTime,
                exitTime = exitTime
            ).calculateParkedDuration(),
            fee = 0,
            vehicleType = vehicleType,
            entryTime = ticket.entryTime,
            exitTime = exitTime
        )
    }
}
