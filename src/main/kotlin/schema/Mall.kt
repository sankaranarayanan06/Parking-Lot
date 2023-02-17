package schema

import exception.InvalidVehicleTypeException
import exception.ParkingSpotUnavailableException
import schema.VehicleType.CAR
import java.util.*

class Mall {
    private val fare = 10
    private val totalParkingSpot = 100
    private val parkingLot = Collections.nCopies(totalParkingSpot, false).toMutableList()

    fun parkVehicle(ticket: Ticket) {
        parkingLot[ticket.getAllocatedParkingLotNumber()] = true
    }

    fun unParkVehicle(ticket: Ticket) {
        parkingLot[ticket.getAllocatedParkingLotNumber()] = false
    }

    fun getFreeParkingSpot(vehicle: VehicleType): Int {
        if (vehicle == CAR) {
            for (spot in parkingLot.indices) {
                if (parkingLot[spot] == false) {
                    parkingLot[spot] = true
                    return spot
                }
            }
            throw ParkingSpotUnavailableException()
        }
        throw InvalidVehicleTypeException()
    }

    fun calculateFee(vehicle: VehicleType, parkedDuration: Long): Long {
        if (vehicle == CAR) {
            return parkedDuration * fare
        }
        throw InvalidVehicleTypeException()
    }
}