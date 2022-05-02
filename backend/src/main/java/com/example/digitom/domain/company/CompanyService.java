package com.example.digitom.domain.company;

import com.example.digitom.service.account.RegistrationRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyService {

    @Resource
    private CompanyMapper companyMapper;
    @Resource
    private CompanyRepository companyRepository;

    public Company addNewCompany(RegistrationRequest registrationRequest) {

        Company company = companyMapper.registrationRequestToCompany(registrationRequest);
        companyRepository.save(company);
        return company;
    }


    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    public CompanyDto getCompanyById(Integer companyId) {


        return companyMapper.toDto(companyRepository.getById(companyId));
    }
}
