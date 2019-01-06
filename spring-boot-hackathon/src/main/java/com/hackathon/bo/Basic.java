/**
 *
 */
package com.hackathon.bo;

import java.io.Serializable;


/**
 * @author mbollampalli
 */
public class Basic implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error
     *            the error to set
     */
    public void setError(final String error) {
        this.error = error;
    }

    private String status;
    private String error;
}
