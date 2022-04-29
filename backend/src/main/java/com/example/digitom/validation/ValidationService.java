package com.example.digitom.validation;


import com.example.digitom.domain.user.UserRepository;
import com.example.digitom.domain.user.UserService;
import com.example.digitom.infrastructure.exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ValidationService {


    public static final String EMAIL_ALREADY_TAKEN = "Email on kasutusel";

    public void emailAlreadyExists(String email, Boolean exists) {
        if (exists) {
            throw new BusinessException(EMAIL_ALREADY_TAKEN, "Isikukood " + email + " on juba kasutusel");
        }
    }
}
