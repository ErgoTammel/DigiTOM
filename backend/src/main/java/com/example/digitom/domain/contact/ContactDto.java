package com.example.digitom.domain.contact;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactDto implements Serializable {
    private final Integer id;
    private final Integer userId;
    private final String userEmail;
    private final String userPassword;
    private final String phoneNumber;
    private final String firstName;
    private final String middleName;
    private final String lastName;
}
