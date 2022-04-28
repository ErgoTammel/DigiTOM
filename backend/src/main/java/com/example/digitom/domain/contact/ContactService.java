package com.example.digitom.domain.contact;

import com.example.digitom.service.registration.RegistrationRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactMapper contactMapper;
    @Resource
    private ContactRepository contactRepository;

    public void addNewContact(RegistrationRequest registrationRequest) {
        Contact contact = contactMapper.registrationRequestToContact(registrationRequest);
        contactRepository.save(contact);
    }

}
