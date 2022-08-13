package com.devbrunorafael.microservice_sendmail.api.controllers;

import com.devbrunorafael.microservice_sendmail.api.dto.inputs.EmailInput;
import com.devbrunorafael.microservice_sendmail.domain.model.Email;
import com.devbrunorafael.microservice_sendmail.domain.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/emails")
public class EmailController {

    private EmailService emailService;

    @PostMapping("/sendmail")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Email> sendMail(@RequestBody @Valid EmailInput emailInput){
        Email email = new Email();
        BeanUtils.copyProperties(emailInput, email);
        return null;
    }

}
