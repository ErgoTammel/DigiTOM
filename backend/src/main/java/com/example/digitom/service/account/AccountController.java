package com.example.digitom.service.account;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/register")
    @Operation(summary = "Register new account")
    public void addNewAccount(@RequestBody RegistrationRequest registrationRequest) {
        accountService.addNewAccount(registrationRequest);
    }

    @PostMapping("/login")
    @Operation(summary = "Get and check the login email and password")
    public LoginResponse logIn(@RequestBody LoginRequest loginRequest) {
        return accountService.logIn(loginRequest);
    }

    @GetMapping("/login/name")
    @Operation(summary = "Get the user's first-, middle- and lastnames")
    public UserNameResponse getUserName(@RequestParam Integer userId) {
        return accountService.getUserName(userId);
    }

    }

