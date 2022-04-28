package com.example.digitom.domain.company;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CompanyService {

    @Resource
    private CompanyMapper companyMapper;
    @Resource
    private CompanyRepository companyRepository;

    public void addNewCompany(CompanyDto companyDto) {

        Company company = companyMapper.toEntity((companyDto));
        companyRepository.save(company);

    }
}
