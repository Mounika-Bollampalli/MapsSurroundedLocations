/**
 *
 */
package com.hackathon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hackathon.bo.LoginBO;
import com.hackathon.entity.Login;
import com.hackathon.service.ILoginService;


/**
 * @author mbollampalli
 */
@RestController
@RequestMapping("hackathon")
@CrossOrigin(origins = { "*" })
public class LoginController {
    @Autowired
    ILoginService loginService;

    @PostMapping("login")
    public ResponseEntity<LoginBO> getLogin(@RequestBody final Login login) {
        final LoginBO loginStatus = loginService.getLogin(login);
        if (loginStatus == null) {
            return new ResponseEntity<LoginBO>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<LoginBO>(loginStatus, HttpStatus.CREATED);
    }

    @GetMapping("logout")
    public ResponseEntity<Void> getlogout(final HttpServletRequest request) {
        final HttpSession session = request.getSession();
        session.invalidate();
        return new ResponseEntity<Void>(HttpStatus.OK);

    }

}
