package schema

import exception.ParkingSlotUnavailable
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MallTest {
    @BeforeEach
    fun setup() {
        TICKET_NUMBER = 0
    }

    @Test
    fun `it should get a spot for parking vehicle`() {
        val location = Mall()
        val expectedResponse = 0

        val response = location.getFreeParkingSpot()

        assertEquals(expectedResponse, response)
    }

    @Test
    fun `it should not get a spot for parking vehicle`() {
        val location = Mall()
        val ticket = Ticket()

        for (i in 1..100) {
            location.getFreeParkingSpot()
            location.parkVehicle(ticket)
        }

        assertThrows<ParkingSlotUnavailable> {
            location.getFreeParkingSpot()
        }
    }
}