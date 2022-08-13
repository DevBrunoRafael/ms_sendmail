package com.devbrunorafael.microservice_sendmail.domain.service;

import com.devbrunorafael.microservice_sendmail.domain.repository.EmailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private EmailRepository emailRepository;


}
