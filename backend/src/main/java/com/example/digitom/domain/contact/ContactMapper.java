package com.example.digitom.domain.contact;

import com.example.digitom.service.account.RegistrationRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "userEmail", target = "user.email")
    @Mapping(source = "userPassword", target = "user.password")
    Contact toEntity(ContactDto contactDto);


    Contact registrationRequestToContact(RegistrationRequest registrationRequest);

}
