package com.example.digitom.domain.contact;

import com.example.digitom.domain.user.User;
import com.example.digitom.service.account.RegistrationRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-11T14:59:23+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public Contact toEntity(ContactDto contactDto) {
        if ( contactDto == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setUser( contactDtoToUser( contactDto ) );
        contact.setId( contactDto.getId() );
        contact.setPhoneNumber( contactDto.getPhoneNumber() );
        contact.setFirstName( contactDto.getFirstName() );
        contact.setMiddleName( contactDto.getMiddleName() );
        contact.setLastName( contactDto.getLastName() );

        return contact;
    }

    @Override
    public Contact registrationRequestToContact(RegistrationRequest registrationRequest) {
        if ( registrationRequest == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setPhoneNumber( registrationRequest.getPhoneNumber() );
        contact.setFirstName( registrationRequest.getFirstName() );
        contact.setMiddleName( registrationRequest.getMiddleName() );
        contact.setLastName( registrationRequest.getLastName() );

        return contact;
    }

    protected User contactDtoToUser(ContactDto contactDto) {
        if ( contactDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( contactDto.getUserId() );
        user.setEmail( contactDto.getUserEmail() );
        user.setPassword( contactDto.getUserPassword() );

        return user;
    }
}
