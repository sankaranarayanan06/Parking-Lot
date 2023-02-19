package model

import java.time.LocalDateTime
import kotlin.random.Random

class TicketDispenser(
    val ticketNumber: Int = Random.nextInt(until = Int.MAX_VALUE),
    val vehicleType: VehicleType = VehicleType.CAR,
    val entryTime: LocalDateTime = LocalDateTime.now(),
    val allocatedParkingSpot: Int
) {
    fun generateTicket(): Ticket {
        return Ticket(ticketNumber, vehicleType, entryTime, allocatedParkingSpot)
    }

}
