package com.example.digitom.validation;


import com.example.digitom.infrastructure.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService {

    public static final String EMAIL_ALREADY_TAKEN = "Email on kasutusel";

    public void emailAlreadyExists(String email, boolean accountExists) {
        if (accountExists) {
            throw new BusinessException(EMAIL_ALREADY_TAKEN, "Isikukood " + email + " on juba kasutusel");
        }
    }
}
