package model

import exception.SpotAlreadyAcquired
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class ParkingLotTest {
    @Test
    fun `it should check if a free spot is available`() {
        val parkingLot = ParkingLot(totalNumberOfSpot = 100)

        val response = parkingLot.run { isSpotAvailable() }

        assertTrue(response)
    }

    @Test
    fun `it should return a free spot`() {
        val parkingLot = ParkingLot(totalNumberOfSpot = 100)
        val expectedResponse = 1

        val response = parkingLot.run { getFreeSpot() }

        assertEquals(expectedResponse, response)
    }

//    @Test
//    fun `it should return the same instance of parkingLot`() {
//        val parkingLot1 = ParkingLot(totalNumberOfSpot = 100)
//        val parkingLot2 = ParkingLot(totalNumberOfSpot = 100)
//
//        assertEquals(parkingLot1, parkingLot2)
//    }

    @Test
    fun `it should not allocate an already reserved spot`() {
        val parkingLot = ParkingLot(totalNumberOfSpot = 100)

        parkingLot.run { acquireFreeSpot(1) }

        assertThrows<SpotAlreadyAcquired> {
            parkingLot.run { acquireFreeSpot(1) }
        }
    }
}