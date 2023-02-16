package schema

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MallTest{
    @Test
    fun `it should get a spot for parking vehicle`() {
        val location = Mall()
        val expectedResponse = 0

        val response = location.getFreeParkingSpot()

        assertEquals(expectedResponse,response)
    }

    @Test
    fun `it should not get a spot for parking vehicle`() {
        val location = Mall()
        val expectedResponse = null

        for(i in 1..99){
            location.getFreeParkingSpot()
        }
        val response = location.getFreeParkingSpot()

        assertEquals(expectedResponse,response)
    }
}