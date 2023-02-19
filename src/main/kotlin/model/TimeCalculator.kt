package model

import java.time.Duration
import java.time.LocalDateTime
import kotlin.math.ceil

class TimeCalculator(
    private val entryTime: LocalDateTime,
    private val exitTime: LocalDateTime
) {

    fun calculateParkedDuration(): Duration {
        return Duration.between(entryTime, exitTime)
    }

    fun convertToHours(): Long {
        return ceil(((Duration.between(entryTime, exitTime).toMinutes().toDouble()) / 60)).toLong()
    }
}