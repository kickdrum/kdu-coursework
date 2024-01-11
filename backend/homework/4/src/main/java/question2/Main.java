package question2;

public class Main {

    public static void main(String[] args) {
        TicketReservation ticketReservation = new TicketReservation();

        bookFlights(ticketReservation);

        displayPassengerInformation(ticketReservation);

        cancelReservation(ticketReservation, "conf123");

        displayPassengerInformation(ticketReservation);
    }

    private static void bookFlights(TicketReservation ticketReservation) {
        ticketReservation.bookFlight("Prashant", "Shukla", 23, "Male", "Economy", "CONF123");
        ticketReservation.bookFlight("Priyank", "Shukla", 30, "Male", "Business", "CONF124");
        ticketReservation.bookFlight("Kshitiza", "Mishra", 22, "Female", "First Class", "CONF125");
        ticketReservation.bookFlight("Chaitanya", "Aghi", 45, "Male", "Economy", "CONF126");
        ticketReservation.bookFlight("Murli", "Pandey", 28, "Male", "Economy", "CONF127");
    }

    private static void cancelReservation(TicketReservation ticketReservation, String confirmationNumber) {
        ticketReservation.cancel(confirmationNumber);
    }

    private static void displayPassengerInformation(TicketReservation ticketReservation) {
        System.out.println("\nPassenger Information:");
        for (Passenger passenger : ticketReservation.confirmedList) {
            System.out.println(passenger.getFirstName() + " " + passenger.getLastName() +
                    " (Confirmation Number: " + passenger.getConfirmationNumber() + ")");
        }

        System.out.println("\nWaiting List Information:");
        for (Passenger passenger : ticketReservation.waitingList) {
            System.out.println(passenger.getFirstName() + " " + passenger.getLastName() +
                    " (Confirmation Number: " + passenger.getConfirmationNumber() + ")");
        }
    }
}
