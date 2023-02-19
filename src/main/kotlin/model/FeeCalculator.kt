package model

class FeeCalculator {
    private val fees = 10
    fun calculate(duration: Long): Long {
        return duration * fees
    }
}
