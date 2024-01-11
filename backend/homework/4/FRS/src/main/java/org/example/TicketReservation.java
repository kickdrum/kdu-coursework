package org.example;

import java.util.*;

public class TicketReservation {

    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    public List<Passenger> getConfirmedList() {
        return confirmedList;
    }

    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass,String confirmationNumber) {
        Passenger  passenger = new Passenger(firstName,lastName,age,gender,travelClass,confirmationNumber);
        Logging logging = new Logging();
        logging.logString(passenger.toString());
        if(confirmedList.size()<CONFIRMEDLIST_LIMIT){
            confirmedList.add(passenger);
            return true;
        }
        else if(waitingList.size()<WAITINGLIST_LIMIT){
            waitingList.add(passenger);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean cancel(String confirmationNumber) {
        Iterator<Passenger> iterator = confirmedList.iterator();
        Iterator<Passenger> waitingiterator = waitingList.iterator();
        if(removePassenger(iterator,confirmationNumber)){
            Passenger waiting = waitingList.poll();
            if(waiting!=null){
                confirmedList.add(waiting);
            }
            return true;
        }
        else return removePassenger(waitingiterator, confirmationNumber);
    }


    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {

        while(iterator.hasNext()){
            Passenger passenger = iterator.next();
            if(passenger.getConfirmationNumber().equals(confirmationNumber)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}
