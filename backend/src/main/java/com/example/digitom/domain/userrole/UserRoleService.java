package com.example.digitom.domain.userrole;

import com.example.digitom.domain.role.Role;
import com.example.digitom.domain.role.RoleDto;
import com.example.digitom.domain.role.RoleRepository;
import com.example.digitom.domain.user.UserDto;
import com.example.digitom.domain.user.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRoleService {

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleRepository userRoleRepository;

    public void addNewUserRole(UserDto userDto, RoleDto roleDto) {
        Role foundRole = roleRepository.findByName(roleDto.getName());
        UserRole userRole = new UserRole();
        userRole.setRole(foundRole);
        userRole.setUser(userMapper.toEntity(userDto));
        userRoleRepository.save(userRole);
    }
}
