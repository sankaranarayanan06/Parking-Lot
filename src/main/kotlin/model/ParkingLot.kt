package model

import java.util.*

class ParkingLot(
    val totalNumberOfSpot: Int
) {
    private val parkingSpots: List<Boolean>
    private var numberOfAvailableSpot: Int

    init {
        parkingSpots = Collections.nCopies(totalNumberOfSpot, true).toMutableList()
        numberOfAvailableSpot = totalNumberOfSpot
    }

    fun getFreeSpot(): Int? {
        for (spot in parkingSpots.indices) {
            if (parkingSpots[spot]) {
                return spot + 1
            }
        }
        return null
    }

    fun isSpotAvailable(): Boolean {
        return numberOfAvailableSpot > 0
    }

}
