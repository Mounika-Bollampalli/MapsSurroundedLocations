/**
 *
 */
package com.hackathon.bo;

/**
 * @author mbollampalli
 */

public class LoginBO extends Basic {

    /**
    *
    */
    private static final long serialVersionUID = 1L;

    private int login_id;
    private String first_name;
    private String last_name;
    private String email;
    private String email_confirm;
    private String password;
    private String password_confirm;
    private String role;

    /**
     * @return the login_id
     */
    public int getLogin_id() {
        return login_id;
    }

    /**
     * @param login_id
     *            the login_id to set
     */
    public void setLogin_id(final int login_id) {
        this.login_id = login_id;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name
     *            the first_name to set
     */
    public void setFirst_name(final String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name
     *            the last_name to set
     */
    public void setLast_name(final String last_name) {
        this.last_name = last_name;
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

    /**
     * @return the email_confirm
     */
    public String getEmail_confirm() {
        return email_confirm;
    }

    /**
     * @param email_confirm
     *            the email_confirm to set
     */
    public void setEmail_confirm(final String email_confirm) {
        this.email_confirm = email_confirm;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return the password_confirm
     */
    public String getPassword_confirm() {
        return password_confirm;
    }

    /**
     * @param password_confirm
     *            the password_confirm to set
     */
    public void setPassword_confirm(final String password_confirm) {
        this.password_confirm = password_confirm;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(final String role) {
        this.role = role;
    }

}
