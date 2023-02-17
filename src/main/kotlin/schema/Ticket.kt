package schema

import exception.InvalidVehicleTypeException
import schema.VehicleType.CAR
import java.time.LocalDateTime
import java.time.LocalTime

var TICKET_NUMBER = 0

class Ticket(
    private val ticketNumber: Int = ++TICKET_NUMBER,
    private val entryDate: LocalDateTime = LocalDateTime.now(),
    private var allocatedParkingLotNumber: Int = Mall().getFreeParkingSpot(CAR),
    private var vehicle: VehicleType
) {
    init {
        if (vehicle != CAR) {
            throw InvalidVehicleTypeException()
        }
    }

    fun generateTicket(): String {
        return "Parking Ticket:\n\t" +
                "Ticket Number:\t$ticketNumber\n\t" +
                "Spot number:\t$allocatedParkingLotNumber\n\t" +
                "Entry Date:\t${entryDate.withNano(0).toLocalTime()}"
    }

    fun getAllocatedParkingLotNumber(): Int {
        return allocatedParkingLotNumber
    }

    fun getEntryDate(): LocalTime {
        return entryDate.withNano(0).toLocalTime()
    }

    fun getVehicle(): VehicleType {
        return vehicle
    }

}