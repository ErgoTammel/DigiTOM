package com.example.digitom.domain.userrole;

import com.example.digitom.domain.role.Role;
import com.example.digitom.domain.role.RoleRepository;
import com.example.digitom.domain.user.User;
import com.example.digitom.service.account.RegistrationRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRoleService {

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private UserRoleRepository userRoleRepository;

    public void addNewUserRole(RegistrationRequest registrationRequest, User user) {
        Role foundRole = roleRepository.findByRoleName(registrationRequest.getRoleName());
        UserRole userRole = new UserRole();
        userRole.setRole(foundRole);
        userRole.setUser(user);

        userRoleRepository.save(userRole);
    }

    public UserRole findUserRoleByUserId(Integer id) {
        return  userRoleRepository.findUserRoleByUserId(id);

    }
}
