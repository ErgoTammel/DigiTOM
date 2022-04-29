package com.example.digitom.domain.companyuser;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyUserService {

    @Resource
    private CompanyUserRepository companyUserRepository;

    public void addNewCompanyUser(Company company, User user) {
        CompanyUser companyUser = new CompanyUser();
        companyUser.setCompany(company);
        companyUser.setUser(user);
        companyUserRepository.save(companyUser);

    }

//    public List<CompanyUser> getAllUserCompanies(Integer userId) {
//        return companyUserRepository.findByUserId(userId);
//    }

    public List<Integer> getAllUserCompanyIds(Integer userId) {
        List<CompanyUser> companyUsers = companyUserRepository.findByUserId(userId);
        List<Integer> companyUsersIds = new ArrayList<>();
        for (CompanyUser companyUser : companyUsers) {
            companyUsersIds.add(companyUser.getId());
        }
        return companyUsersIds;
    }
}
