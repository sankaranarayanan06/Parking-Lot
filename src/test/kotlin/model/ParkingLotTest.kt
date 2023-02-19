package model

import exception.SpotAlreadyAcquired
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class ParkingLotTest {
    @Test
    fun `it should check if a free spot is available`() {
        val parkingLot = Singleton.getParkingLotInstance(totalNumberOfSpot = 100)

        val response = parkingLot?.run { isSpotAvailable() }

        assertTrue(response!!)
    }

    @Test
    fun `it should return a free spot`() {
        val parkingLot = Singleton.getParkingLotInstance(totalNumberOfSpot = 100)
        val expectedResponse = 1

        val response = parkingLot?.run { getFreeSpot() }

        assertEquals(expectedResponse, response)
    }

    @Test
    fun `it should return the same instance of parkingLot`() {
        val parkingLot1 = Singleton.getParkingLotInstance(totalNumberOfSpot = 100)
        val parkingLot2 = Singleton.getParkingLotInstance(totalNumberOfSpot = 100)

        assertEquals(parkingLot1, parkingLot2)
    }

    @Test
    fun `it should not allocate an already reserved spot`() {
        val parkingLot1 = Singleton.getParkingLotInstance(totalNumberOfSpot = 100)
        parkingLot1?.run { acquireFreeSpot(1) }

        val parkingLot2 = Singleton.getParkingLotInstance(totalNumberOfSpot = 100)


        assertThrows<SpotAlreadyAcquired> {
            parkingLot2?.run { acquireFreeSpot(1) }
        }
    }
}