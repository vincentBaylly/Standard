/*
 * Copyright (c) 2015, Charter.
 */
package org.standard.bestpratice.bean;

import java.io.Serializable;

/**
 * @author vincent.baylly
 */
public class ContactPrefTO implements Serializable {

    private static final long serialVersionUID = -1367039180925926405L;
    private String contactDataValue;
    private String contactMethodId;

    /**
     * Getter for contactData.
     * 
     * @return the contactData
     */
    public String getContactDataValue() {
        return contactDataValue;
    }

    /**
     * Setter for contactData.
     * 
     * @param contactData the contactData to set
     */
    public void setContactDataValue(final String contactDataValue) {
        this.contactDataValue = contactDataValue;
    }

    /**
     * Getter for contactMethod.
     * 
     * @return the contactMethod
     */
    public String getContactMethodId() {
        return contactMethodId;
    }

    /**
     * Setter for contactMethod.
     * 
     * @param contactMethod the contactMethod to set
     */
    public void setContactMethodId(final String contactMethodId) {
        this.contactMethodId = contactMethodId;
    }
    
    public String toString(){
    	return new StringBuffer().append("contactMethodId : " + getContactMethodId() + " ").append("contactDataValue : " + getContactDataValue()+ "\n").toString();
    }
}
