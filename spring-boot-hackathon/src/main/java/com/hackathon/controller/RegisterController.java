/**
 *
 */
package com.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hackathon.entity.Register;
import com.hackathon.mailserver.MailServer;
import com.hackathon.service.IRegisterService;


/**
 * @author mbollampalli
 */
@RestController
@RequestMapping("hackathon")
@CrossOrigin(origins = { "*" })
public class RegisterController {

    @Autowired
    IRegisterService registerService;
    @Autowired
    MailServer mailServer;

    @PostMapping("register")
    public ResponseEntity<Register> createReg(@RequestBody final Register register) {
        final Register regStatus = registerService.createReg(register);

        if (regStatus.getReg_id() == 0) {
            return new ResponseEntity<Register>(HttpStatus.CONFLICT);
        }
        mailServer.sendMail(register.getEmail_confirm());
        return new ResponseEntity<Register>(regStatus, HttpStatus.CREATED);
    }

    @GetMapping("{email}/registerEmail")
    public ResponseEntity<Register> emailCheck(@PathVariable("email") final String email) {

        final Register emailStatus = registerService.emailCheck(email);
        if (emailStatus != null && emailStatus.equals(email)) {
            return new ResponseEntity<Register>(emailStatus, HttpStatus.OK);
        }
        return new ResponseEntity<Register>(emailStatus, HttpStatus.OK);

    }

}
