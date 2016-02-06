package org.standard.bestpratice.bean;

import java.io.Serializable;

/**
 * @author vincent.baylly
 */
public class AppointmentPrefTO implements Serializable {

    private static final long serialVersionUID = 4403337333893109703L;

    private String contactType;
    private String contactValue;

    /**
     * Getter for contactType.
     * 
     * @return the contactType
     */
    public String getContactType() {
        return contactType;
    }

    /**
     * Setter for contactType.
     * 
     * @param contactType the contactType to set
     */
    public void setContactType(final String contactType) {
        this.contactType = contactType;
    }

    /**
     * Getter for contactValue.
     * 
     * @return the contactValue
     */
    public String getContactValue() {
        return contactValue;
    }

    /**
     * Setter for contactValue.
     * 
     * @param contactValue the contactValue to set
     */
    public void setContactValue(final String contactValue) {
        this.contactValue = contactValue;
    }

}
