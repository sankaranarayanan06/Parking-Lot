package model

class ParkingLot(
    val totalNumberOfSpot: Int
) {
    fun getFreeSpot(): Int {
        return 1
    }

    fun isSpotAvailable(): Boolean {
        return true
    }

}
