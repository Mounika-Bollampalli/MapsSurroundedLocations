/**
 *
 */
package com.hackathon.dao;

import com.hackathon.entity.Register;


/**
 * @author mbollampalli
 */
public interface IRegisterDAO {
    public int createReg(Register register);

    public Register emailCheck(String email);
}
