package model

import exception.SpotAlreadyAcquired
import java.util.*

//object Singleton {
//    private var instance: ParkingLot? = null
//    fun getParkingLotInstance(totalNumberOfSpot: Int): ParkingLot? {
//        instance?.run {
//            return instance
//        } ?: run {
//            instance = ParkingLot(totalNumberOfSpot = totalNumberOfSpot)
//            return instance
//        }
//    }
//}

class ParkingLot(
    totalNumberOfSpot: Int
) {
    private val parkingSpots = Collections.nCopies(totalNumberOfSpot, true).toMutableList()
    private var numberOfAvailableSpot: Int = totalNumberOfSpot

    fun getFreeSpot(): Int? {
        for (spot in parkingSpots.indices) {
            if (parkingSpots[spot]) {
                return spot + 1
            }
        }
        return null
    }

    fun acquireFreeSpot(spot: Int) {
        if (parkingSpots[spot - 1]) {
            parkingSpots[spot - 1] = false
        } else {
            throw SpotAlreadyAcquired()
        }
    }

    fun isSpotAvailable(): Boolean {
        return numberOfAvailableSpot > 0
    }

}
