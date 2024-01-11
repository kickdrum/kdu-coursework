package org.example.question2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class ticketreservation {

    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<passenger> confirmedList = new ArrayList<>();
    private Deque<passenger> waitingList = new ArrayDeque<>();


    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass,
                              String confirmationNumber) {
        if (confirmedList.size() == CONFIRMEDLIST_LIMIT && waitingList.size() == WAITINGLIST_LIMIT) {
            return false;
        }

        passenger passenger = new passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);

        if (confirmedList.size() < CONFIRMEDLIST_LIMIT) {
            return confirmedList.add(passenger);
        } else {
            return waitingList.add(passenger);
        }
    }

    public boolean cancel(String confirmationNumber) {
        boolean flag = removePassenger(confirmedList.iterator(), confirmationNumber);

        if (flag) {
            // Move first-waiting passenger into passengerList
            passenger waitingPassenger = waitingList.poll();
            if (waitingPassenger != null) {
                confirmedList.add(waitingPassenger);
            }
        } else {
            // Passenger canceling the ticket is from Waiting List
            flag = removePassenger(waitingList.iterator(), confirmationNumber);
        }

        return flag;
    }

    public boolean removePassenger(Iterator<passenger> iterator, String confirmationNumber) {
        while (iterator.hasNext()) {
            passenger passenger = iterator.next();
            if (passenger.getConfirmationNumber().equals(confirmationNumber)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

}
