package schema

import java.time.LocalDateTime
import java.time.LocalTime

var TICKET_NUMBER = 0

class Ticket(
    private val ticketNumber: Int = ++TICKET_NUMBER,
    private val entryDate: LocalTime = LocalDateTime.now().withNano(0).toLocalTime(),
) {
    private var parkedSpot: Int = 0

    init {
        Mall().getFreeParkingSpot()?.let { parkedSpot = it }
    }
    fun generateTicket(): String {
        return "Parking Ticket:\n\t" +
                "Ticket Number:\t$ticketNumber\n\t" +
                "Spot number:\t$parkedSpot\n\t" +
                "Entry Date:\t${entryDate}"
    }

    fun getParkingSpot(): Int {
        return parkedSpot
    }
}