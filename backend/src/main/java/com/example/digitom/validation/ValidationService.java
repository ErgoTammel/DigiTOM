package com.example.digitom.validation;


import com.example.digitom.domain.task.Task;
import com.example.digitom.domain.user.User;
import com.example.digitom.infrastructure.exception.BusinessException;
import com.example.digitom.infrastructure.exception.DataNotFoundException;
import com.example.digitom.service.account.LoginRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ValidationService {


    public static final String EMAIL_ALREADY_TAKEN = "Email on kasutusel";
    public static final String USER_DOES_NOT_EXISTS = "Kasutajanimi või parool on vale";
    public static final String NO_COMPANY_RESPONSIBLE = "Vastutav ettevõte puudub";
    public static final String NO_DESCRIPTION = "Kirjeldus puudub";
    public static final String DEADLINE_NOT_EXISTS = "Tähtaeg puudub";
    public static final String TASKS_NOT_FOUND = "Korrastamisülesandeid ei leitud";


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

    public void taskCompanyExists(Integer companyId) {
        if (companyId == 0) {
            throw new DataNotFoundException(NO_COMPANY_RESPONSIBLE, "Sisesta vastutav ettevõte!");
        }
    }


    public void taskDescriptionExists(String description) {
        if (description.equals("string")) {
            throw new DataNotFoundException(NO_DESCRIPTION, "Lisa leitud puuduse kirjeldus!");
        }
    }

    public void taskDeadlineExists(Integer deadline) {
        if (deadline == 0) {
            throw new DataNotFoundException(DEADLINE_NOT_EXISTS, "Sisesta korrastamisülesande tähtaeg!");
        }

    }

    public void incidentListExists(List<Task> tasks) {
        if (tasks.size() == 0) {
            throw new DataNotFoundException(TASKS_NOT_FOUND, "Lisa uus korrastamisülesanne!");
        }
    }
}
