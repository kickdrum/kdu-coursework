package org.handson.question4;

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
     * @param  nurseId the nurse ID to set
     */
    public void setNurseId(long nurseId) {
        this.nurseId = nurseId;
    }
}
