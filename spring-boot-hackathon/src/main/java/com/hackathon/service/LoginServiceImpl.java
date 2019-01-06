/**
 *
 */
package com.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hackathon.bo.LoginBO;
import com.hackathon.dao.ILoginDAO;
import com.hackathon.entity.Login;


/**
 * @author mbollampalli
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    ILoginDAO loginDAO;

    @Override
    public LoginBO getLogin(final Login login) {
        final Login loginObj = loginDAO.getLogin(login.getEmail());
        if (loginObj != null && loginObj.getPassword().equalsIgnoreCase(login.getPassword())) {

            return mapLogin(loginObj);

        }
        return null;
    }

    public LoginBO mapLogin(final Login loginObj) {
        final LoginBO loginBO = new LoginBO();
        loginBO.setLogin_id(loginObj.getLogin_id());
        loginBO.setEmail(loginObj.getEmail());
        loginBO.setEmail_confirm(loginObj.getEmail_confirm());
        loginBO.setPassword(loginObj.getPassword());
        loginBO.setPassword_confirm(loginObj.getPassword_confirm());
        loginBO.setRole(loginObj.getRole());
        loginBO.setFirst_name(loginObj.getFirst_name());
        loginBO.setStatus("Success");
        return loginBO;

    }
}
