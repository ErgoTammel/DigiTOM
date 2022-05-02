package com.example.digitom.domain.company;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/company")
@RestController
public class CompanyController {


    @Resource
    private CompanyService companyService;


    @GetMapping("/name")
   public CompanyDto getCompanyById(@RequestParam Integer companyId){
       return companyService.getCompanyById(companyId);
   }
}
