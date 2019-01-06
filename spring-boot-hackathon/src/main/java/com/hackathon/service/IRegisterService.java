/**
 *
 */
package com.hackathon.service;

import com.hackathon.entity.Register;


/**
 * @author mbollampalli
 */
public interface IRegisterService {
    public Register createReg(Register register);

    public Register emailCheck(String email);
}
