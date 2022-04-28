package com.example.digitom.domain.contact;

import com.example.digitom.service.registration.RegistrationRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "userEmail", target = "user.email")
    @Mapping(source = "userPassword", target = "user.password")
    Contact toEntity(ContactDto contactDto);


    Contact registrationRequestToContact(RegistrationRequest registrationRequest);

//    @InheritInverseConfiguration(name = "toEntity")
//    ContactDto toDto(Contact contact);
//
//    @InheritConfiguration(name = "contactDtoToContact")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateContactFromContactDto(ContactDto contactDto, @MappingTarget Contact contact);
}
