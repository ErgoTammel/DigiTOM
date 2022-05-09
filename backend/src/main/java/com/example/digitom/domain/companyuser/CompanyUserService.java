package com.example.digitom.domain.companyuser;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.contact.ContactService;
import com.example.digitom.domain.user.User;
import com.example.digitom.service.constractionsitemanagement.CompanyContactResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyUserService {

    @Resource
    private CompanyUserRepository companyUserRepository;

    @Resource
    private ContactService contactService;

    public void addNewCompanyUser(Company company, User user) {
        CompanyUser companyUser = new CompanyUser();
        companyUser.setCompany(company);
        companyUser.setUser(user);
        companyUserRepository.save(companyUser);

    }

    public List<Integer> getUserCompanyIdsByUserIds(Integer userId) {
        List<CompanyUser> companyUsers = companyUserRepository.findAllByUserId(userId);
        List<Integer> companyUsersIds = new ArrayList<>();
        for (CompanyUser companyUser : companyUsers) {
            companyUsersIds.add(companyUser.getId());
        }
        return companyUsersIds;
    }

    public List<CompanyContactResponse> getCompanyUsersByCompanyId(Integer companyId) {
        List<CompanyUser> companyUsers = companyUserRepository.findByCompanyId(companyId);
        List<CompanyContactResponse> companyContacts = new ArrayList<>();
        for (CompanyUser companyUser : companyUsers) {
            CompanyContactResponse companyContactResponse = new CompanyContactResponse();
            Integer userId = companyUser.getUser().getId();

            companyContactResponse.setContactId(contactService.getUserName(userId).getId());
            companyContactResponse.setFirstName(contactService.getUserName(userId).getFirstName());
            companyContactResponse.setMiddleName(contactService.getUserName(userId).getMiddleName());
            companyContactResponse.setLastName(contactService.getUserName(userId).getLastName());
            companyContacts.add(companyContactResponse);
        }
        return companyContacts;
    }

}
