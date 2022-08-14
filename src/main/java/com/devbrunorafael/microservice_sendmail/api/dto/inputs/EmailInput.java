package com.devbrunorafael.microservice_sendmail.api.dto.inputs;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailInput {

    @NotBlank
    private String ownerRef;

    @Email
    @NotBlank
    private String emailFrom;
    @Email
    @NotBlank
    private String emailTo;

    @NotBlank
    private String subject;
    @NotBlank
    private String text;

}
