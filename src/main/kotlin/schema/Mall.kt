package schema

import java.util.*

class Mall {
    private val fare = 10
    private val totalParkingSpot = 100
    private val parkingLot = Collections.nCopies(totalParkingSpot, false).toMutableList()

    fun parkVehicle(ticket: Ticket){
        parkingLot[ticket.spot] = true
    }

    fun getFreeParkingSpot(): Int? {
        for (spot in parkingLot.indices) {
            if (parkingLot[spot] == false) {
                return spot
            }
        }
        return null
    }

}