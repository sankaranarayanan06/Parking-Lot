package model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class ReceiptDispenserTest {
    @Test
    fun `it should generate a receipt when a ticket is presented`() {
        val ticket = ParkingLot(totalNumberOfSpot = 100).getFreeSpot()?.let {
            TicketDispenser(
                ticketNumber = 101,
                vehicleType = VehicleType.CAR,
                entryTime = LocalDateTime.of(2023, 2, 19, 12, 15).truncatedTo(ChronoUnit.MINUTES),
                allocatedParkingSpot = it
            ).generateTicket()
        }
        val receipt = ticket?.let {
            ReceiptDispenser(
                ticket = it,
                receiptNumber = 101,
                vehicleType = VehicleType.CAR,
                exitTime = LocalDateTime.of(2023, 2, 19, 15, 30).truncatedTo(ChronoUnit.MINUTES),
            )
        }
        val expectedResponse = Receipt(
            receiptNumber = 101,
            fee = 40,
            vehicleType = VehicleType.CAR,
            entryTime = LocalDateTime.of(2023, 2, 19, 12, 15).truncatedTo(ChronoUnit.MINUTES),
            exitTime = LocalDateTime.of(2023, 2, 19, 15, 30).truncatedTo(ChronoUnit.MINUTES),
            parkedDuration = Duration.of(195, ChronoUnit.MINUTES),
        )

        val response = receipt?.run { generateReceipt() }

        Assertions.assertEquals(expectedResponse, response)
    }
}