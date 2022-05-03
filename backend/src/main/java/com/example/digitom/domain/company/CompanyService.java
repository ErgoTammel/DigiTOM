package com.example.digitom.domain.company;

import com.example.digitom.service.account.RegistrationRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        List<Company> companies = companyRepository.getById();
        List<CompanyDto> companyDtos = new ArrayList<>();
        for (Company company : companies) {
            CompanyDto companyDto = company(company);

        }
        return companyRepository.findAll();
    }

    public CompanyDto getCompanyById(Integer companyId) {


        return companyMapper.toDto(companyRepository.getById(companyId));
    }

        public void removeCompanyById(Integer companyId) {
            companyRepository.deleteById(companyId);
        }

    public List<CompanyDto> getAllCompanies() {
        return null;
    }
}
