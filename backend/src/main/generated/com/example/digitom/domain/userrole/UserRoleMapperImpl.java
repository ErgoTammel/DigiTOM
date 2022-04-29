package com.example.digitom.domain.userrole;

import com.example.digitom.domain.role.Role;
import com.example.digitom.domain.user.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-28T20:45:26+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class UserRoleMapperImpl implements UserRoleMapper {

    @Override
    public UserRole userRoleDtoToUserRole(UserRoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        UserRole userRole = new UserRole();

        userRole.setUser( userRoleDtoToUser( roleDto ) );
        userRole.setRole( userRoleDtoToRole( roleDto ) );
        userRole.setId( roleDto.getId() );

        return userRole;
    }

    @Override
    public UserRoleDto userRoleToUserRoleDto(UserRole userRole) {
        if ( userRole == null ) {
            return null;
        }

        Integer userId = null;
        String userEmail = null;
        String userPassword = null;
        Integer roleId = null;
        String roleName = null;
        Integer id = null;

        userId = userRoleUserId( userRole );
        userEmail = userRoleUserEmail( userRole );
        userPassword = userRoleUserPassword( userRole );
        roleId = userRoleRoleId( userRole );
        roleName = userRoleRoleName( userRole );
        id = userRole.getId();

        UserRoleDto userRoleDto = new UserRoleDto( id, userId, userEmail, userPassword, roleId, roleName );

        return userRoleDto;
    }

    @Override
    public void updateUserRoleFromUserRoleDto(UserRoleDto roleDto, UserRole userRole) {
        if ( roleDto == null ) {
            return;
        }

        if ( userRole.getUser() == null ) {
            userRole.setUser( new User() );
        }
        userRoleDtoToUser1( roleDto, userRole.getUser() );
        if ( userRole.getRole() == null ) {
            userRole.setRole( new Role() );
        }
        userRoleDtoToRole1( roleDto, userRole.getRole() );
        if ( roleDto.getId() != null ) {
            userRole.setId( roleDto.getId() );
        }
    }

    protected User userRoleDtoToUser(UserRoleDto userRoleDto) {
        if ( userRoleDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userRoleDto.getUserId() );
        user.setEmail( userRoleDto.getUserEmail() );
        user.setPassword( userRoleDto.getUserPassword() );

        return user;
    }

    protected Role userRoleDtoToRole(UserRoleDto userRoleDto) {
        if ( userRoleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( userRoleDto.getRoleId() );
        role.setName( userRoleDto.getRoleName() );

        return role;
    }

    private Integer userRoleUserId(UserRole userRole) {
        if ( userRole == null ) {
            return null;
        }
        User user = userRole.getUser();
        if ( user == null ) {
            return null;
        }
        Integer id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String userRoleUserEmail(UserRole userRole) {
        if ( userRole == null ) {
            return null;
        }
        User user = userRole.getUser();
        if ( user == null ) {
            return null;
        }
        String email = user.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }

    private String userRoleUserPassword(UserRole userRole) {
        if ( userRole == null ) {
            return null;
        }
        User user = userRole.getUser();
        if ( user == null ) {
            return null;
        }
        String password = user.getPassword();
        if ( password == null ) {
            return null;
        }
        return password;
    }

    private Integer userRoleRoleId(UserRole userRole) {
        if ( userRole == null ) {
            return null;
        }
        Role role = userRole.getRole();
        if ( role == null ) {
            return null;
        }
        Integer id = role.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String userRoleRoleName(UserRole userRole) {
        if ( userRole == null ) {
            return null;
        }
        Role role = userRole.getRole();
        if ( role == null ) {
            return null;
        }
        String name = role.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected void userRoleDtoToUser1(UserRoleDto userRoleDto, User mappingTarget) {
        if ( userRoleDto == null ) {
            return;
        }

        if ( userRoleDto.getUserId() != null ) {
            mappingTarget.setId( userRoleDto.getUserId() );
        }
        if ( userRoleDto.getUserEmail() != null ) {
            mappingTarget.setEmail( userRoleDto.getUserEmail() );
        }
        if ( userRoleDto.getUserPassword() != null ) {
            mappingTarget.setPassword( userRoleDto.getUserPassword() );
        }
    }

    protected void userRoleDtoToRole1(UserRoleDto userRoleDto, Role mappingTarget) {
        if ( userRoleDto == null ) {
            return;
        }

        if ( userRoleDto.getRoleId() != null ) {
            mappingTarget.setId( userRoleDto.getRoleId() );
        }
        if ( userRoleDto.getRoleName() != null ) {
            mappingTarget.setName( userRoleDto.getRoleName() );
        }
    }
}
