package com.example.digitom.domain.companyuser;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public List<CompanyUser> getAllUserCompanies(Integer userId) {
        return companyUserRepository.findByUserId(userId);
    }
}
