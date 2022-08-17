package com.devbrunorafael.microservice_sendmail.api.dto.outputs;

import com.devbrunorafael.microservice_sendmail.domain.enums.ShippingStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EmailOutput {

    private String emailTo;
    private String subject;
    private String text;
    private ShippingStatus status;

}
