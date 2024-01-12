package kdu.homework;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TicketReservation ticketReservation = new TicketReservation();
        Logs logger = new Logs();

        for(int i=0;i<13;i++){
            String firstName = "Passenger ";
            String lastName = Integer.toString(i+1);
            String gender = "male";
            String travelClass = "Buisness";
            String confirmationNumber = Integer.toString(i+1);
            boolean isBooked = ticketReservation.bookFlight(firstName, lastName, i+1, gender, travelClass, confirmationNumber);
        }

        logger.console(ticketReservation.getConfirmedList().toString());
        logger.console(ticketReservation.getWaitingList().toString());
        logger.console("\n");

        ticketReservation.cancel("10");

        logger.console(ticketReservation.getConfirmedList().toString());
        logger.console(ticketReservation.getWaitingList().toString());
        logger.console("\n");

        ticketReservation.cancel("13");

        logger.console(ticketReservation.getConfirmedList().toString());
        logger.console(ticketReservation.getWaitingList().toString());
        logger.console("\n");

        ticketReservation.cancel("2");

        logger.console(ticketReservation.getConfirmedList().toString());
        logger.console(ticketReservation.getWaitingList().toString());
    }
}