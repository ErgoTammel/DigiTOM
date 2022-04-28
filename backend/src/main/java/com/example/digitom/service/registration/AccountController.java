package com.example.digitom.service.registration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/registration")
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/add")
    public void addNewAccount(@RequestBody RegistrationRequest registrationRequest) {
        accountService.addNewAccount(registrationRequest);
    }

}
