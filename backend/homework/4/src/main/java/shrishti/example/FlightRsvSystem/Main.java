package shrishti.example.FlightRsvSystem;
import shrishti.example.Logger.logger;
public class Main {
    public static void main(String[] args) {
        TicketReservation ticketReservation = new TicketReservation();

        bookFlight(ticketReservation);

        getPassengerInfo(ticketReservation);

        cancelTicket(ticketReservation, "conf123");

        getPassengerInfo(ticketReservation);
    }

    private static void bookFlight(TicketReservation ticketReservation) {
        ticketReservation.bookFlight("shrishti", "gupta", 22, "F", "Business", "C7");
        ticketReservation.bookFlight("AAkash", "tyagi", 25, "M", "Economy", "C12");
        ticketReservation.bookFlight("thanika", "vijay", 32, "F", "Business", "C3");
        ticketReservation.bookFlight("Rishav", "shukla", 23, "M", "Economy", "C8");
    }

    private static void cancelTicket(TicketReservation ticketReservation, String confirmationNumber) {
        ticketReservation.cancel(confirmationNumber);
    }

    private static void getPassengerInfo(TicketReservation ticketReservation) {
        logger.printLogger("Passenger Info:");
        for (Passenger passenger : ticketReservation.confirmedList) {
            logger.printLogger(passenger.getFirstName() + " " + passenger.getLastName() +
                    " (Confirmation Number: " + passenger.getConfirmationNumber() + ")");
        }

        logger.printLogger("\nWaiting List Information:");
        for (Passenger passenger : ticketReservation.waitingList) {
            logger.printLogger(passenger.getFirstName() + " " + passenger.getLastName() +
                    " (Confirmation Number: " + passenger.getConfirmationNumber() + ")");
        }
    }
}
