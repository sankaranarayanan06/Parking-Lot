package model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class TicketDispenserTest {
    @Test
    fun `it should generate a ticket`() {
        val ticket = TicketDispenser(
            ticketNumber = 101,
            vehicleType = VehicleType.CAR,
            entryTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES),
            allocatedParkingSpot = ParkingLot(totalNumberOfSpot = 100).accquireFreeSpot()
        )
        val expectedResponse = Ticket(
            ticketNumber = 101,
            vehicleType = VehicleType.CAR,
            entryTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES),
            allocatedParkingSpot = ParkingLot(totalNumberOfSpot = 100).accquireFreeSpot()
        )

        val response = ticket.generateTicket()

        Assertions.assertEquals(expectedResponse, response)
    }
}