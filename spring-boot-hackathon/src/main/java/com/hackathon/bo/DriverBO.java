/**
 *
 */
package com.hackathon.bo;

import java.util.List;


/**
 * @author mbollampalli
 */

public class DriverBO extends Basic {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int driver_id;
    private String name;
    private String ph_no;
    private String email;
    private String address;
    private List<PackageDetailsBO> package_details;

    /**
     * @return the package_details
     */
    public List<PackageDetailsBO> getPackage_details() {
        return package_details;
    }

    /**
     * @param package_details
     *            the package_details to set
     */
    public void setPackage_details(final List<PackageDetailsBO> package_details) {
        this.package_details = package_details;
    }

    /**
     * @return the driver_id
     */
    public int getDriver_id() {
        return driver_id;
    }

    /**
     * @param driver_id
     *            the driver_id to set
     */
    public void setDriver_id(final int driver_id) {
        this.driver_id = driver_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the ph_no
     */
    public String getPh_no() {
        return ph_no;
    }

    /**
     * @param ph_no
     *            the ph_no to set
     */
    public void setPh_no(final String ph_no) {
        this.ph_no = ph_no;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(final String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

}
