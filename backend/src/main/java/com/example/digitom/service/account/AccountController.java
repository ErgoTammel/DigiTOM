package com.example.digitom.service.account;

import com.example.digitom.domain.constructionsite.ConstructionSite;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/register")
    public void addNewAccount(@RequestBody RegistrationRequest registrationRequest) {
        accountService.addNewAccount(registrationRequest);
    }

    @PostMapping("/login")
    public LoginResponse logIn(@RequestBody LoginRequest loginRequest) {
        return accountService.logIn(loginRequest);
    }

    @GetMapping("/login/name")
    public UserNameResponse getUserName(@RequestParam Integer userId) {
        return accountService.getUserName(userId);
    }

    }

