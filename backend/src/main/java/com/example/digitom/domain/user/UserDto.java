package com.example.digitom.domain.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private final Integer id;
    private final String email;
    private final String password;
}
