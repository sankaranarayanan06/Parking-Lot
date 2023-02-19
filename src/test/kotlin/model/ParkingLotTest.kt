package model

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ParkingLotTest {
    @Test
    fun `it should check if a free spot is available`() {
        val parkingLot = ParkingLot(totalNumberOfSpot = 100)

        val response = parkingLot.isSpotAvailable()

        assertTrue(response)
    }

    @Test
    fun `it should return a free spot`() {
        val parkingLot = ParkingLot(totalNumberOfSpot = 100)
        val expectedResponse = 1

        val response = parkingLot.accquireFreeSpot()

        assertEquals(expectedResponse, response)
    }
}