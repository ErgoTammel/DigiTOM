package com.example.digitom.domain.company;


import com.example.digitom.service.account.RegistrationRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/company")
@RestController
public class CompanyController {

    @Resource
    private CompanyService companyService;


    @GetMapping("/name")
   public CompanyDto getCompanyById(@RequestParam Integer companyId){
       return companyService.getCompanyById(companyId);
   }

    @PostMapping("/new")
    public Company addNewCompany(@RequestBody RegistrationRequest registrationRequest) {
        return companyService.addNewCompany(registrationRequest);
    }

     @PutMapping("/company")
    public void updateCompanyById(@RequestParam Integer companyId, @RequestParam CompanyDto companyDto) {
        companyService.getCompanyById(companyId, companyDto);
    }


    @GetMapping("/all")
    public List<CompanyDto> getAllCompanies() {
        return companyService.getAllCompanies();
    }


    @DeleteMapping("/id")
    public void removeCompanyById(@RequestParam Integer companyId) {
        companyService.removeCompanyById(companyId);
    }

}
