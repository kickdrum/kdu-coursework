package ques2;
import java.util.*;
class TicketReservation {
    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;
    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    /**
     *
     * @param firstName
     * @param lastName
     * @param age
     * @param gender
     * @param travelClass
     * @param confirmationNumber
     * @return
     */
    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        if(confirmedList.size() == CONFIRMEDLIST_LIMIT && waitingList.size() == WAITINGLIST_LIMIT)
            return false;

        Passenger newPassenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);

        if(confirmedList.size() == CONFIRMEDLIST_LIMIT){
            waitingList.add(newPassenger);
            return true;
        }

        confirmedList.add(newPassenger);
        return true;
    }

    /**
     *
     * @param confirmationNumber
     * @return
     */
    public boolean cancel(String confirmationNumber) {
        Iterator<Passenger> confirmedIterator = confirmedList.iterator();
        boolean checkRemoved = removePassenger(confirmedIterator, confirmationNumber);

        if (checkRemoved) {
            if (!waitingList.isEmpty()) {
                Passenger nextPassenger = waitingList.poll();
                confirmedList.add(nextPassenger);
            }
            return true;
        }
        else {
            Iterator<Passenger> waitingIterator = waitingList.iterator();
            return removePassenger(waitingIterator, confirmationNumber);
        }
    }

    /**
     *
     * @param iterator
     * @param confirmationNumber
     * @return
     */
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