package org.handson.question3;

public class Nurse extends Staff {
    private long nurseId;
    /**
     * Retrieves the nurse ID.
     *
     * @return the nurse ID
     */
    public long getNurseId() {
        return nurseId;
    }
    /**
     * Sets the nurse ID.
     *
     * @param  nurseId  the ID of the nurse
     */ 
    public void setNurseId(long nurseId) {
        this.nurseId = nurseId;
    }
}
