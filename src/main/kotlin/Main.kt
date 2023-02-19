import model.*
import java.time.LocalDateTime

val issuedTickets = mutableListOf<Ticket>()

fun main() {
    val parkingLot = ParkingLot(totalNumberOfSpot = 100)

    if (parkingLot.isSpotAvailable()) {
        val ticket = parkingLot.getFreeSpot()?.let {
            TicketDispenser(
                ticketNumber = 1,
                allocatedParkingSpot = it
            ).generateTicket()
        }
        if(ticket != null){
            issuedTickets.add(ticket)
            parkingLot.parkVehicle(ticket.allocatedParkingSpot)
        }
    }else{
        // No space to park :(
    }

    //Unpark function
    val ticket = getTicketFromTicketId(ticketNumber = 1)
    if (ticket != null) {
        parkingLot.unparkVehicle(ticket.allocatedParkingSpot)
        val receipt = ReceiptDispenser(
            ticket = ticket,
            exitTime = LocalDateTime.of(2023,2,20,21,0)
        ).generateReceipt()
        println(receipt)
    }

}

fun getTicketFromTicketId(ticketNumber:Int): Ticket? {
    for(ticket in issuedTickets){
        if(ticket.ticketNumber == ticketNumber){
            return ticket
        }
    }
    return null
}