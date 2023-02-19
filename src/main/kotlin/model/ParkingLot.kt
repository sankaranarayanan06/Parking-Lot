package model

import java.util.*

class ParkingLot(
    val totalNumberOfSpot: Int
) {
    private val parkingSpot: List<Boolean>
    private var numberOfAvailableSpot: Int

    init {
        parkingSpot = Collections.nCopies(totalNumberOfSpot, true).toMutableList()
        numberOfAvailableSpot = totalNumberOfSpot
    }

    fun accquireFreeSpot(): Int {
        return 1
    }

    fun isSpotAvailable(): Boolean {
        return numberOfAvailableSpot > 0
    }

}
