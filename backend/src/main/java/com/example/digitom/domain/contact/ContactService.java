package com.example.digitom.domain.contact;

import com.example.digitom.domain.user.User;
import com.example.digitom.service.account.RegistrationRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactMapper contactMapper;
    @Resource
    private ContactRepository contactRepository;

    public void addNewContact(RegistrationRequest registrationRequest, User user) {
        Contact contact = contactMapper.registrationRequestToContact(registrationRequest);
        contact.setUser(user);
        contactRepository.save(contact);
    }


    public Contact getUserName(Integer userId) {
        return contactRepository.findByUserId(userId);

    }
}
