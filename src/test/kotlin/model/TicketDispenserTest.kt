package model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class TicketDispenserTest {
    @Test
    fun `it should generate a ticket`() {
        val ticket = ParkingLot(totalNumberOfSpot = 100).getFreeSpot()?.let {
            TicketDispenser(
                ticketNumber = 101,
                vehicleType = VehicleType.CAR,
                entryTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES),
                allocatedParkingSpot = it
            )
        }

        val expectedResponse = Ticket(
            ticketNumber = 101,
            vehicleType = VehicleType.CAR,
            entryTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES),
            allocatedParkingSpot = 1
        )

        val response = ticket?.run { generateTicket() }

        assertEquals(expectedResponse, response)
    }
}