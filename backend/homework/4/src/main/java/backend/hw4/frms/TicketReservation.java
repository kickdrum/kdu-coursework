package backend.hw4.frms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class TicketReservation {

    private static final int CONFIRMEDLIST_LIMIT = 2;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    public List<Passenger> getConfirmedList() {
        return confirmedList;
    }
    public Deque<Passenger> getWaitingList() {
        return waitingList;
    }

    /**
     * this method is implemented to return true if the passenger can be added to either the confirmedList or the waitingList. The passenger will only be added to the waitingList if the confirmedList is already full,it returns false if both the passengerList and the waitingList are at full capacity.
     * @param firstName
     * @param lastName
     * @param age
     * @param gender
     * @param travelClass
     * @param confirmationNumber
     * @return
     */
    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        Passenger passenger = new Passenger(firstName,lastName,age,gender,travelClass,confirmationNumber);
        if (confirmedList.size() < CONFIRMEDLIST_LIMIT){
            confirmedList.add(passenger);
            return true;
        } else if (waitingList.size() < WAITINGLIST_LIMIT) {
            waitingList.offer(passenger);
            return true;
        } else {
            return false;
        }

    }
    /**
     * In this cancel method we are deleting the passenger associated with the provided confirmation number. The passenger may exist in either the confirmedList or the waitingList. The removal operation is implemented within the removePassenger() method, and this method will be independently tested using the provided test scripts.
     * If the passenger is present in the confirmedList, after removal, the passenger at the front of the waitingList (if it is not empty) should be transferred to the confirmedList. The poll() method (not remove()) is used to extract the passenger from the waitingList.
     * @param confirmationNumber
     * @return
     */
    public boolean cancel(String confirmationNumber) {
        boolean removed = removePassenger(confirmedList.iterator(), confirmationNumber);
        if(!removed){
            removed = removePassenger(waitingList.iterator(), confirmationNumber);
        }
        if(removed && !waitingList.isEmpty()){
            Passenger passenger = waitingList.poll();
            confirmedList.add(passenger);
        }
        return removed;
    }
    /**
     * this method is implemented to remove the passenger with the given confirmation number and it return true only if the passenger was present and removed from it otherwise it return false
     * @param iterator
     * @param confirmationNumber
     * @return
     */
    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        while (iterator.hasNext()){
            Passenger passenger = iterator.next();
            if (passenger.getConfirmationNumber().equals(confirmationNumber)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}