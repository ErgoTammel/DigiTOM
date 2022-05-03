package com.example.digitom.validation;


import com.example.digitom.domain.user.User;
import com.example.digitom.infrastructure.exception.BusinessException;
import com.example.digitom.infrastructure.exception.DataNotFoundException;
import com.example.digitom.service.account.LoginRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ValidationService {


    public static final String EMAIL_ALREADY_TAKEN = "Email on kasutusel";
    public static final String USER_DOES_NOT_EXISTS = "Kasutajanimi või parool on vale";

    public void emailAlreadyExists(String email, Boolean exists) {
        if (exists) {
            throw new BusinessException(EMAIL_ALREADY_TAKEN, "Email " + email + " on juba kasutusel");
        }
    }

    public void userExist(String email, Boolean emailExists) {
        if (Boolean.FALSE.equals(emailExists)) {
            throw new DataNotFoundException("Emaili" + email + "ei leitud!", "Proovi uuesti.");
        }
    }

    public void passwordValidation(User userFound, LoginRequest loginRequest) {
        if (!Objects.equals(userFound.getPassword(), loginRequest.getPassword())) {
            throw new DataNotFoundException(USER_DOES_NOT_EXISTS, "Proovi uuesti!");
        }
    }

    public void userExist(Optional<User> user) {
        if (user.isEmpty()) {
            throw new BusinessException("Viga sisenemisel", "Sisesta õiged andmed või registreeri konto");
        }
    }

    public void companyConstructionSiteExist(String companyName, Boolean exist) {
        if(exist){
            throw new BusinessException("Alltöövõtja "+ companyName+" on juba objektile lisatud!", "Proovi uuesti!");
        }
    }

}
