package schema

import exception.ParkingSpotUnavailableException
import exception.InvalidVehicleTypeException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import schema.VehicleType.BIKE
import schema.VehicleType.CAR

class MallTest {
    @BeforeEach
    fun setup() {
        TICKET_NUMBER = 0
    }

    @Test
    fun `it should test for an invalid vehicle type`() {
        val location = Mall()

        assertThrows<InvalidVehicleTypeException> {
            location.getFreeParkingSpot(BIKE)
        }
    }

    @Test
    fun `it should get a spot for parking car in the mall`() {
        val location = Mall()
        val expectedResponse = 0

        val response = location.getFreeParkingSpot(CAR)

        assertEquals(expectedResponse, response)
    }

    @Test
    fun `it should not get a spot for parking car in the mall`() {
        val location = Mall()
        val ticket = Ticket(vehicle = CAR)

        for (i in 1..100) {
            location.getFreeParkingSpot(CAR)
            location.parkVehicle(ticket)
        }

        assertThrows<ParkingSpotUnavailableException> {
            location.getFreeParkingSpot(CAR)
        }
    }

    @Test
    fun `it should calculate the fee for the parked duration`() {
        val location = Mall()
        val expectedResponse = 30L

        val response = location.calculateFee(CAR, 3)

        assertEquals(expectedResponse, response)
    }
}