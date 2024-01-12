package ques2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        logger.info("Main method started");

        TicketReservation ticketReservation = new TicketReservation();

        ticketReservation.bookFlight("Khushi", "Rani", 30, "Female", "Economy", "123abc");
        ticketReservation.bookFlight("Mathangi", "K", 25, "Female", "Business", "DEF456");

        String cancellationNumber = "DEF456";
        boolean cancellationResult = ticketReservation.cancel(cancellationNumber);
        logger.info("Cancellation Result: {}", cancellationResult);

        logger.info("Main method completed");
    }

}
