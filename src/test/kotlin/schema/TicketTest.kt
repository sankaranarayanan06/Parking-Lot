package schema

import exception.UnknownVehicleException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import schema.VehicleType.*
import java.time.LocalDateTime

class TicketTest {
    @BeforeEach
    fun setup(){
        TICKET_NUMBER = 0
    }

    @Test
    fun `it should not generate a ticket for a Bike`() {
        assertThrows<UnknownVehicleException> {
            Ticket(vehicle = BIKE)
        }
    }

    @Test
    fun `it should generate a ticket for a CAR to be parked in the mall`() {
        //Arrange
        val ticket = Ticket(vehicle = CAR)
        val expectedResponse = "Parking Ticket:\n\t" +
                "Ticket Number:\t1\n\t" +
                "Spot number:\t0\n\t" +
                "Entry Date:\t${LocalDateTime.now().withNano(0).toLocalTime()}"

        //Act
        val response = ticket.generateTicket()

        //Assert
        assertEquals(expectedResponse, response)
    }
}