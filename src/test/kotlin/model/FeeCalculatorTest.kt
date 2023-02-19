package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FeeCalculatorTest {
    @Test
    fun `it should calculate the fee`() {
        val calculator = FeeCalculator()
        val expectedResponse = 40L

        val response = calculator.calculate(4)

        assertEquals(expectedResponse,response)
    }
}