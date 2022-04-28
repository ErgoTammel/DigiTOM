package com.example.digitom.service.registration;

import com.example.digitom.domain.company.CompanyDto;
import com.example.digitom.domain.contact.ContactDto;
import com.example.digitom.domain.role.RoleDto;
import com.example.digitom.domain.user.UserDto;
import lombok.Data;

@Data
public class RegistrationRequest {

    private ContactDto contactDto;
    private CompanyDto companyDto;
    private UserDto userDto;
    private RoleDto roleDto;



}
