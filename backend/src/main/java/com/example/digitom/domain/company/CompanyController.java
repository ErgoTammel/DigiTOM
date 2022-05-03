package com.example.digitom.domain.company;


import com.example.digitom.service.account.RegistrationRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/company")
@RestController
public class CompanyController {

//    todo: teha 4 meetodit, kus 1 lisab uue company, 1 muudab olemasolevat companyt ja 1 kustutab company,
//    need kõik käivad id järgi. Lisaks teha 1, mis tagastab kõik companyd andmebaasist üldse.


    @Resource
    private CompanyService companyService;


    @GetMapping("/name")
   public CompanyDto getCompanyById(@RequestParam Integer companyId){
       return companyService.getCompanyById(companyId);
   }


    @PostMapping("/new")
    public CompanyDto addNewCompany(@RequestBody CompanyDto companyDto) {
        return companyService.addNewCompany(companyDto);

    }

    // meetod, mis muudab olemasolevat companyt
    @PutMapping("/company")
    public void updateCompanyById(@RequestParam Integer companyId, @RequestParam CompanyDto companyDto) {
        companyService.getCompanyById(companyId, companyDto);

    }

    //    meetod, mis tagastab kõik companyd andmebaasist üldse
    @GetMapping("/all")
    public List<CompanyDto> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @DeleteMapping("/id")
    public void removeCompanyById(@RequestParam Integer companyId) {
        companyService.removeCompanyById(companyId);
    }

}
