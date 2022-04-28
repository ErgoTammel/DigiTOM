package com.example.digitom.service.registration;

import com.example.digitom.domain.company.CompanyService;
import com.example.digitom.domain.contact.ContactService;
import com.example.digitom.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountService {
    @Resource
    private ContactService contactService;
    @Resource
    private CompanyService companyService;

    private UserService userService;


    public void addNewAccount(RegistrationRequest registrationRequest) {

        contactService.addNewContact(registrationRequest.getContactDto());

        companyService.addNewCompany(registrationRequest.getCompanyDto());

        userService.addNewUser(registrationRequest.getUserDto());

    }
}
