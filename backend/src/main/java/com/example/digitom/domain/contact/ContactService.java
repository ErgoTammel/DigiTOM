package com.example.digitom.domain.contact;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactMapper contactMapper;
    @Resource
    private ContactRepository contactRepository;

    public void addNewContact(ContactDto contactDto) {

        Contact contact = contactMapper.toEntity(contactDto);
        contactRepository.save(contact);

    }

}
