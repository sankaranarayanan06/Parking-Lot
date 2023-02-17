package schema

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import schema.VehicleType.CAR
import java.time.LocalDateTime

class ReceiptTest {
    @Test
    fun `it should generate the receipt`() {
        val location = Mall()
        val ticket = Ticket(entryDate = LocalDateTime.of(2023, 1, 1, 10, 0, 0), vehicle = CAR)
        location.unParkVehicle(ticket)
        val receipt = Receipt(exitDate = LocalDateTime.of(2023, 1, 1, 11, 30, 0), ticket = ticket)
        val expectedResponse =
            "Parking Receipt:\n\t" +
                    "Receipt Number:\t1\n\t" +
                    "Entry Date:\t10:00\n\t" +
                    "Exit Date:\t11:30\n\t" +
                    "Fees:\t20\n\t"

        val response = receipt.generateReceipt()

        assertEquals(expectedResponse, response)
    }
}