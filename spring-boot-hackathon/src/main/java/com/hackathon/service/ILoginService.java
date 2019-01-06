/**
 *
 */
package com.hackathon.service;

import com.hackathon.bo.LoginBO;
import com.hackathon.entity.Login;


/**
 * @author mbollampalli
 */
public interface ILoginService {

    public LoginBO getLogin(Login login);
}
