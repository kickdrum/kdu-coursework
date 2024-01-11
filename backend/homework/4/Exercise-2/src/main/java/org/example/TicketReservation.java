package org.example;
import java.util.*;

public class TicketReservation {
    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private final List<Passenger> confirmedList = new ArrayList<>();
    private final Deque<Passenger> waitingList = new ArrayDeque<>();

    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass,
                              String confirmationNumber) {
        Passenger passenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);

        if (confirmedList.size() < CONFIRMEDLIST_LIMIT) {
            confirmedList.add(passenger);
            // Booking successful and return true
            return true;
        } else if (waitingList.size() < WAITINGLIST_LIMIT) {
            waitingList.offer(passenger);
            // Booking successful added to waiting list
            return true;
        } else {
            // booking failed due to confirmedList and waitingList are full
            return false;
        }
    }

    public boolean cancel(String confirmationNumber) {
        // Remove the passenger from confirmedList or waitingList
        boolean removed = removePassenger(confirmedList.iterator(), confirmationNumber);

        if (!removed) {
            // If not found in confirmedList, try removing from waitingList
            removed = removePassenger(waitingList.iterator(), confirmationNumber);

            // If removed from waitingList, move the first passenger from waitingList to confirmedList
            if (removed && !waitingList.isEmpty()) {
                confirmedList.add(waitingList.poll());
            }
        }

        return removed;
    }

    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        while (iterator.hasNext()) {
            Passenger passenger = iterator.next();
            if (passenger.getConfirmationNumber().equals(confirmationNumber)) {
                iterator.remove();
                // Passenger removed from the list
                return true;
            }
        }
        // Passenger not found in the list
        return false;
    }

    public Iterable<Passenger> getConfirmedList() {
        return confirmedList;
    }

    public Iterable<Passenger> getWaitingList() {
        return waitingList;
    }
}
