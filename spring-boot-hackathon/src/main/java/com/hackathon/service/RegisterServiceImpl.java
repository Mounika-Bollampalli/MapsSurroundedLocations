/**
 *
 */
package com.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hackathon.dao.IRegisterDAO;
import com.hackathon.entity.Register;


/**
 * @author mbollampalli
 */
@Service
public class RegisterServiceImpl implements IRegisterService {

    @Autowired
    IRegisterDAO registerDAoImpl;

    @Override
    public synchronized Register createReg(final Register register) {
        // TODO Auto-generated method stub
        final int flagStatus = registerDAoImpl.createReg(register);
        register.setReg_id(flagStatus);
        return register;
    }

    @Override
    public Register emailCheck(final String email) {
        return registerDAoImpl.emailCheck(email);
    }

}
