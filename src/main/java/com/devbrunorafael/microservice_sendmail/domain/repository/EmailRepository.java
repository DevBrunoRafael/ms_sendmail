package com.devbrunorafael.microservice_sendmail.domain.repository;

import com.devbrunorafael.microservice_sendmail.domain.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> { }
