package com.example.digitom.domain.company;


import com.example.digitom.service.account.RegistrationRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/company")
@RestController
public class CompanyController {

    @Resource
    private CompanyService companyService;


    @GetMapping("/name")
    @Operation(summary = "Get the company by ID")
    public CompanyDto getCompanyById(@RequestParam Integer companyId) {
        return companyService.getCompanyById(companyId);
    }

    @PostMapping("/new")
    @Operation(summary = "Register new company")
    public Company addNewCompany(@RequestBody RegistrationRequest registrationRequest) {
        return companyService.addNewCompany(registrationRequest);
    }

    @PutMapping("/company")
    @Operation(summary = "Update the company information")
    public void updateCompanyById(@RequestParam Integer companyId, @RequestParam CompanyDto companyDto) {
        companyService.getCompanyById(companyId, companyDto);
    }


    @GetMapping("/all")
    @Operation(summary = "Get the list of all companies")
    public List<CompanyDto> getAllCompanies() {
        return companyService.getAllCompanies();
    }


    @DeleteMapping("/id")
    @Operation(summary = "Delete the company by ID")
    public void removeCompanyById(@RequestParam Integer companyId) {
        companyService.removeCompanyById(companyId);
    }

}
