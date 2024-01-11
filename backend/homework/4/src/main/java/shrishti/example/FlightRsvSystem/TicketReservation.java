package shrishti.example.FlightRsvSystem;

import java.util.*;

public class TicketReservation {

    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    final List<Passenger> confirmedList = new ArrayList<>();
    final Deque<Passenger> waitingList = new ArrayDeque<>();

    private boolean isFull(){
        return confirmedList.size() == CONFIRMEDLIST_LIMIT && waitingList.size()==WAITINGLIST_LIMIT;
    }
    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        if (isFull()) {
            return false;
        }
        Passenger passenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);
        if (confirmedList.size() == CONFIRMEDLIST_LIMIT) {
            waitingList.add(passenger);
        } else {
            confirmedList.add(passenger);
        }
        return true;
    }

    public boolean cancel(String confirmationNumber) {

        Iterator<Passenger> cancelPassenger = confirmedList.iterator();
        boolean isRemoved = removePassenger(cancelPassenger, confirmationNumber);
        if(isRemoved) {
            if (!waitingList.isEmpty()) {
                Passenger nextInList = waitingList.poll();
                confirmedList.add(nextInList);

            }
            return true;
        } else {
            Iterator<Passenger> waitIterator = waitingList.iterator();
            return removePassenger(waitIterator, confirmationNumber);
        }
    }

    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {

        while (iterator.hasNext()) {
            Passenger passenger = iterator.next();
            if (passenger.getConfirmationNumber().equals(confirmationNumber)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}