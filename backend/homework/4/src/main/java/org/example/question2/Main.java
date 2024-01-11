package org.example.question2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ticketreservation reservationSystem = new ticketreservation();

        boolean bookingResult = reservationSystem.bookFlight("Tony", "Soprano", 30, "Male", "Economy", "1");

        if (bookingResult) {
            logger.info("Booking successful!");
        } else {
            logger.error("Booking failed. The confirmed list and waiting list are full.");
        }

        String confirmationNumberToCancel = "1";
        boolean cancelResult = reservationSystem.cancel(confirmationNumberToCancel);

        if (cancelResult) {
            logger.info("Cancellation successful!");
        } else {
            logger.error("Cancellation failed. Passenger not found.");
        }
    }
}
