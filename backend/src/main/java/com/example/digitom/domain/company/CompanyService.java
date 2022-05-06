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

    public void getCompanyById(Integer companyId, CompanyDto companyDto) {

        Company company =  companyRepository.findById(companyId).get();
        company.setName(companyDto.getName());
        company.setRegNumber(companyDto.getRegNumber());
    }

    public CompanyDto getCompanyById(Integer companyId) {
                return companyMapper.toDto(companyRepository.getById(companyId));
    }

    public void removeCompanyById(Integer companyId) {
            companyRepository.deleteById(companyId);
        }

    public List<CompanyDto> getAllCompanies() {
        List<Company> all = companyRepository.findAll();
        return companyMapper.toDtos(all);
        }
}
