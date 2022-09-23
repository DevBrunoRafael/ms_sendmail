package com.devbrunorafael.microservice_sendmail.domain.service;

import com.devbrunorafael.microservice_sendmail.domain.enums.ShippingStatus;
import com.devbrunorafael.microservice_sendmail.domain.model.Email;
import com.devbrunorafael.microservice_sendmail.domain.repository.EmailRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@EnableRetry
public class EmailService {

    private EmailRepository emailRepository;
    private JavaMailSender javaMailSender;

    @Transactional
    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 5000), value = {
            MailException.class
    })
    public Email sendMail(Email email){

        email.setSendDateTime(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            javaMailSender.send(message);

            // if it is sent successfully
            email.setStatus(ShippingStatus.SENT);

        } catch (MailException e){
            email.setStatus(ShippingStatus.ERROR);
            e.printStackTrace();
        }

        return this.emailRepository.save(email);
    }

    @Recover
    public String log(){
        return "Não foi possível enviar seu email";
    }

}
