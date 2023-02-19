package model

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ParkingLotTest {
    @Test
    fun `it should check if a free spot is available`() {
        val parkingLot = ParkingLot(100)

        val response = parkingLot.isSpotAvailable()

        assertTrue(response)
    }
}