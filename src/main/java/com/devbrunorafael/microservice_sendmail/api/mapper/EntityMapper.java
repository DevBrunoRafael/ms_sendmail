package com.devbrunorafael.microservice_sendmail.api.mapper;

import com.devbrunorafael.microservice_sendmail.api.dto.inputs.EmailInput;
import com.devbrunorafael.microservice_sendmail.api.dto.outputs.EmailOutput;
import com.devbrunorafael.microservice_sendmail.domain.model.Email;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EntityMapper {

    private ModelMapper modelMapper;

    //    entity -> output
    public EmailOutput toConvert(Email email){
        return modelMapper.map(email, EmailOutput.class);
    }

    //    input -> entity
    public Email toConvert(EmailInput emailInput){
        return modelMapper.map(emailInput, Email.class);
    }
}
