package kdu.homework;

import java.util.*;

public class TicketReservation {

    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    // This getter is used only by the junit test case.
    public Deque<Passenger> getWaitingList() {
        return waitingList;
    }
    public List<Passenger> getConfirmedList() {
        return confirmedList;
    }

    /**
     * Returns true if passenger could be added into either confirmedList or
     * waitingList. Passenger will be added to waitingList only if confirmedList
     * is full.
     *
     * Return false if both passengerList & waitingList are full
     */
    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {

        Passenger passenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);

        if(confirmedList.size()<10){
            confirmedList.add(passenger);
            return true;
        }

        if(waitingList.size()<3){
            waitingList.add(passenger);
            return true;
        }

        return false;

    }

    /**
     * Removes passenger with the given confirmationNumber. Passenger could be
     * in either confirmedList or waitingList. The implementation to remove the
     * passenger should go in removePassenger() method and removePassenger method
     * will be tested separately by the uploaded test scripts.

     * If passenger is in confirmedList, then after removing that passenger, the
     * passenger at the front of waitingList (if not empty) must be moved into
     * passengerList. Use poll() method (not remove()) to extract the passenger
     * from waitingList.
     */
    public boolean cancel(String confirmationNumber) {

        Iterator<Passenger> confirmationIterator = confirmedList.iterator();
        Iterator<Passenger> waitingListIterator = waitingList.iterator();

        if(removePassenger(confirmationIterator, confirmationNumber)){
            return waitingList.isEmpty() ? true : confirmedList.add(waitingList.poll());
        }

        return removePassenger(waitingListIterator, confirmationNumber);
    }

    /**
     * Removes passenger with the given confirmation number.
     * Returns true only if passenger was present and removed. Otherwise, return false.
     */
    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        while(iterator.hasNext()){
            if(iterator.next().getConfirmationNumber().equals(confirmationNumber)){
                iterator.remove();
                return true;
            }
        }

        return false;
    }

}