package com.example.digitom.service.account;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.company.CompanyService;
import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSiteService;
import com.example.digitom.domain.companyuser.CompanyUserService;
import com.example.digitom.domain.contact.Contact;
import com.example.digitom.domain.contact.ContactService;
import com.example.digitom.domain.user.User;
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
    @Resource
    private CompanyUserService companyUserService;
    @Resource
    private CompanyConstructionSiteService companyConstructionSiteService;


    public void addNewAccount(RegistrationRequest registrationRequest) {
        registrationRequest.setEmail(registrationRequest.getEmail().toLowerCase());
        Boolean exists = userService.existsByEmail(registrationRequest.getEmail());
        validationService.emailAlreadyExists(registrationRequest.getEmail(), exists);
        User user = userService.addNewUser(registrationRequest);
        contactService.addNewContact(registrationRequest, user);
        userRoleService.addNewUserRole(registrationRequest, user);
        Company company = companyService.addNewCompany(registrationRequest);
        companyUserService.addNewCompanyUser(company, user);
    }

    public LoginResponse logIn(LoginRequest loginRequest) {
        User validUser = userService.getValidUser(loginRequest);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(validUser.getId());
        return loginResponse;
    }

    public UserNameResponse getUserName(Integer userId) {
        Contact contact = contactService.getUserName(userId);
        UserNameResponse userNameResponse = new UserNameResponse();
        userNameResponse.setUserFirstName(contact.getFirstName());
        userNameResponse.setUserMiddleName(contact.getMiddleName());
        userNameResponse.setUserLastName(contact.getLastName());
        return userNameResponse;
    }

}
