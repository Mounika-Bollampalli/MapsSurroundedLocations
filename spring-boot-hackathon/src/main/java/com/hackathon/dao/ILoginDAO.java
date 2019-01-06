/**
 *
 */
package com.hackathon.dao;

import com.hackathon.entity.Login;


/**
 * @author mbollampalli
 */
public interface ILoginDAO {
    public Login getLogin(String email);
}
