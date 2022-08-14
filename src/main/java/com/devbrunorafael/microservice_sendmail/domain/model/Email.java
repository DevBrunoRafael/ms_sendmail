package com.devbrunorafael.microservice_sendmail.domain.model;

import com.devbrunorafael.microservice_sendmail.domain.enums.ShippingStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_emails")
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String text;

    private LocalDateTime sendDateTime;

    @Enumerated(EnumType.STRING)
    private ShippingStatus status;

}
