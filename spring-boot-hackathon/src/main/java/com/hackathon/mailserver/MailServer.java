/**
 *
 */
package com.hackathon.mailserver;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import com.hackathon.constant.MailConstant;


/**
 * @author mbollampalli
 */
@Component("mailServer")
public class MailServer {
    @Autowired
    JavaMailSender javaMailSender;

    Map<String, Object> modelValue = null;

    public void sendMail(final String to) {
        final SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom(MailConstant.form_mail);
        mail.setTo(to);
        mail.setSubject(MailConstant.subject);
        mail.setText(MailConstant.body);

        // logger.info("Sending...");

        javaMailSender.send(mail);

        // logger.info("Done!");
    }

}
