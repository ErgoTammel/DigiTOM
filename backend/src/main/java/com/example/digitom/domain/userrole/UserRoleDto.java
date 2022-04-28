package com.example.digitom.domain.userrole;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRoleDto implements Serializable {
    private final Integer id;
    private final Integer userId;
    private final String userEmail;
    private final String userPassword;
    private final Integer roleId;
    private final String roleName;
}
