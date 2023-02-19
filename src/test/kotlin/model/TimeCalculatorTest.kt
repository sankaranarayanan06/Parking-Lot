package model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class TimeCalculatorTest {
    @Test
    fun `it should calculate the time duration from entry to exit time`() {
        val timeCalculator = TimeCalculator(
            LocalDateTime.of(2023, 2, 19, 15, 0),
            LocalDateTime.of(2023, 2, 19, 18, 25),
        )
        val expectedResponse = Duration.of(205, ChronoUnit.MINUTES)

        val response = timeCalculator.calculateParkedDuration()

        assertEquals(expectedResponse, response)
    }

    @Test
    fun `it should convert the duration into hours`() {
        val timeCalculator = TimeCalculator(
            LocalDateTime.of(2023, 2, 19, 15, 0),
            LocalDateTime.of(2023, 2, 19, 18, 25),
        )
        val expectedResponse = 4L

        val response = timeCalculator.convertToHours()

        assertEquals(expectedResponse,response)
    }
}