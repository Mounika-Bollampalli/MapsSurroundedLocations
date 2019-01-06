/**
 *
 */
package com.hackathon.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author mbollampalli
 */
@Entity
@Table(name = "driver")
public class Driver implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int driver_id;
    private String name;
    private String email;
    private String ph_no;
    private String address;
    @OneToMany(mappedBy = "driver_details")
    private List<PackageDetails> package_details;

    /**
     * @return the package_details
     */
    public List<PackageDetails> getPackage_details() {
        return package_details;
    }

    /**
     * @param package_details
     *            the package_details to set
     */
    public void setPackage_details(final List<PackageDetails> package_details) {
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
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
