package org.handson.question1and2;

public class Nurse extends Staff{
    private long nurseId;
    /**
     * A description of the getNurseId() function.
     *
     * @return  a long representing the nurseId
     */
    public long getNurseId() {
        return nurseId;
    }
    /**
     * Sets the nurse ID.
     *
     * @param  nurseId  the nurse ID to set
     */
    public void setNurseId(long nurseId) {
        this.nurseId = nurseId;
    }
}
