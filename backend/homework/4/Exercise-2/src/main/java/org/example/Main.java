package org.example;

import org.example.logging.LoggingSystem;

public class Main {

    public static void main(String[] args) {
        final LoggingSystem ls = new LoggingSystem();
        TicketReservation ticketReservation = new TicketReservation();

        boolean bookingResult1 = ticketReservation.bookFlight("Bhuvan", "G", 21, "Male", "Business", "C1");
        boolean bookingResult2 = ticketReservation.bookFlight("Akash", "G", 20, "Female", "Economy", "C2");
        boolean bookingResult3 = ticketReservation.bookFlight("Amit", "Gupta", 23, "Female", "Business", "C3");
        boolean bookingResult4 = ticketReservation.bookFlight("Ambadas", "Appu", 24, "Male", "Economy", "C4");


        ls.logInfo("Booking Result 1: " + bookingResult1);
        ls.logInfo("Booking Result 2: " + bookingResult2);
        ls.logInfo("Booking Result 3: " + bookingResult3);
        ls.logInfo("Booking Result 4: " + bookingResult4);


        ls.logInfo("\nConfirmed List:");
        displayPassengerList(ticketReservation.getConfirmedList());

        ls.logInfo("\nWaiting List:");
        displayPassengerList(ticketReservation.getWaitingList());


        boolean cancelResult = ticketReservation.cancel("C1");
        ls.logInfo("\nCancellation Result: " + cancelResult);


        ls.logInfo("\nConfirmed List after Cancellation:");
        displayPassengerList(ticketReservation.getConfirmedList());

        ls.logInfo("\nWaiting List after Cancellation:");
        displayPassengerList(ticketReservation.getWaitingList());
    }

    private static void displayPassengerList(Iterable<Passenger> passengerList) {
        for (Passenger passenger : passengerList) {
            final LoggingSystem ls = new LoggingSystem();
            ls.logInfo(String.valueOf(passenger));
        }
    }
}