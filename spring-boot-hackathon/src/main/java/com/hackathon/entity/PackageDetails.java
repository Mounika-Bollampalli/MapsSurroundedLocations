/**
 *
 */
package com.hackathon.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author mbollampalli
 */
@Entity
@Table(name = "package_details")
public class PackageDetails implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int package_id;
    private String form_address;
    private String to_address;
    @ManyToOne
    private Driver driver_details;

    /**
     * @return the driver_details
     */
    public Driver getDriver_details() {
        return driver_details;
    }

    /**
     * @param driver_details
     *            the driver_details to set
     */
    public void setDriver_details(final Driver driver_details) {
        this.driver_details = driver_details;
    }

    /**
     * @return the package_id
     */
    public int getPackage_id() {
        return package_id;
    }

    /**
     * @param package_id
     *            the package_id to set
     */
    public void setPackage_id(final int package_id) {
        this.package_id = package_id;
    }

    /**
     * @return the form_address
     */
    public String getForm_address() {
        return form_address;
    }

    /**
     * @param form_address
     *            the form_address to set
     */
    public void setForm_address(final String form_address) {
        this.form_address = form_address;
    }

    /**
     * @return the to_address
     */
    public String getTo_address() {
        return to_address;
    }

    /**
     * @param to_address
     *            the to_address to set
     */
    public void setTo_address(final String to_address) {
        this.to_address = to_address;
    }

}
