package com.example.digitom.domain.role;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T11:51:52+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role roleDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setName( roleDto.getName() );

        return role;
    }

    @Override
    public RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        Integer id = null;
        String name = null;

        id = role.getId();
        name = role.getName();

        RoleDto roleDto = new RoleDto( id, name );

        return roleDto;
    }

    @Override
    public void updateRoleFromRoleDto(RoleDto roleDto, Role role) {
        if ( roleDto == null ) {
            return;
        }

        if ( roleDto.getId() != null ) {
            role.setId( roleDto.getId() );
        }
        if ( roleDto.getName() != null ) {
            role.setName( roleDto.getName() );
        }
    }
}
