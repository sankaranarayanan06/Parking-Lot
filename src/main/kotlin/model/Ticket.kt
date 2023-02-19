package model

import java.time.LocalDateTime

data class Ticket(
    val ticketNumber: Int,
    val vehicleType: VehicleType,
    val entryTime: LocalDateTime,
    val allocatedParkingSpot: Int
)