package model

import java.time.Duration
import java.time.LocalDateTime

class TimeCalculator(
    private val entryTime: LocalDateTime,
    private val exitTime: LocalDateTime
) {

    fun calculateParkedDuration(): Duration {

        return Duration.between(entryTime, exitTime)
    }
}