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
                LocalDateTime.of(2023, 2, 19, 15, 0),
                LocalDateTime.of(2023, 2, 19, 18, 25)
            ).calculateParkedDuration(),
            fee = 0,
            vehicleType = vehicleType,
            entryTime = ticket.entryTime,
            exitTime = exitTime
        )
    }
}
