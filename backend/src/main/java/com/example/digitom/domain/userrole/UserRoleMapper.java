package com.example.digitom.domain.userrole;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserRoleMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "userEmail", target = "user.email")
    @Mapping(source = "userPassword", target = "user.password")
    @Mapping(source = "roleId", target = "role.id")
    @Mapping(source = "roleName", target = "role.name")
    UserRole userRoleDtoToUserRole(UserRoleDto roleDto);

    @InheritInverseConfiguration(name = "userRoleDtoToUserRole")
    UserRoleDto userRoleToUserRoleDto(UserRole userRole);

    @InheritConfiguration(name = "userRoleDtoToUserRole")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserRoleFromUserRoleDto(UserRoleDto roleDto, @MappingTarget UserRole userRole);
}
