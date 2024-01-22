package question2;
import java.util.*;

public class TicketReservation {
    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;
    Collection<Passenger> confirmedList = new ArrayList<>();
    Deque<Passenger> waitingList = new ArrayDeque<>();

    private boolean isFull() {
        return confirmedList.size() == CONFIRMEDLIST_LIMIT && waitingList.size() == WAITINGLIST_LIMIT;
    }
    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        if (isFull()) {
            return false;
        }
        Passenger newPassenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);

        if (confirmedList.size() == CONFIRMEDLIST_LIMIT) {
            waitingList.add(newPassenger);
        } else {
            confirmedList.add(newPassenger);
        }

        return true;
    }
    public boolean cancel(String confirmationNumber) {
        Iterator<Passenger> confirmedIterator = confirmedList.iterator();
        boolean checkRemoved = removePassenger(confirmedIterator, confirmationNumber);

        if (checkRemoved) {
            movePassengerFromWaitingListToConfirmedList();
            return true;
        } else {
            Iterator<Passenger> waitingIterator = waitingList.iterator();
            return removePassenger(waitingIterator, confirmationNumber);
        }
    }
    private void movePassengerFromWaitingListToConfirmedList() {
        if (!waitingList.isEmpty()) {
            Passenger nextPassenger = waitingList.poll();
            confirmedList.add(nextPassenger);
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
