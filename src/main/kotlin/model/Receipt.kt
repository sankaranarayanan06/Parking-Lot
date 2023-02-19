package model

import java.time.Duration
import java.time.LocalDateTime

data class Receipt(
    val receiptNumber: Int,
    val parkedDuration: Duration,
    val fee: Long,
    val vehicleType: VehicleType,
    val entryTime: LocalDateTime,
    val exitTime: LocalDateTime
)
