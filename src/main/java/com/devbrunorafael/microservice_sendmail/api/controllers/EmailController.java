package com.devbrunorafael.microservice_sendmail.api.controllers;

import com.devbrunorafael.microservice_sendmail.api.dto.inputs.EmailInput;
import com.devbrunorafael.microservice_sendmail.api.dto.outputs.EmailOutput;
import com.devbrunorafael.microservice_sendmail.api.mapper.EntityMapper;
import com.devbrunorafael.microservice_sendmail.domain.model.Email;
import com.devbrunorafael.microservice_sendmail.domain.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/emails")
public class EmailController {

    private EmailService emailService;
    private EntityMapper entityMapper;

    @PostMapping("/sendmail")
    @ResponseStatus(HttpStatus.CREATED)
    public EmailOutput sendMail(@Valid @RequestBody EmailInput emailInput){
        Email email = entityMapper.toConvert(emailInput);
        Email emailSent = emailService.sendMail(email);
        return entityMapper.toConvert(emailSent);
    }

}
