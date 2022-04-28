package com.example.digitom.service.registration;

import com.example.digitom.domain.company.CompanyService;
import com.example.digitom.domain.contact.ContactService;
import com.example.digitom.domain.user.UserService;
import com.example.digitom.domain.userrole.UserRoleService;
import com.example.digitom.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountService {
    @Resource
    private ContactService contactService;
    @Resource
    private CompanyService companyService;
    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private ValidationService validationService;


    public void addNewAccount(RegistrationRequest registrationRequest) {
        contactService.addNewContact(registrationRequest);
        userService.addNewUser(registrationRequest);

        companyService.addNewCompany(registrationRequest);



        userRoleService.addNewUserRole(registrationRequest);

        validationService.emailAlreadyExists(registrationRequest.getEmail());

    }
}
