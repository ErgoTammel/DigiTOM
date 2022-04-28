package com.example.digitom.domain.user;

import com.example.digitom.service.registration.RegistrationRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUserDto(UserDto userDto, @MappingTarget User user);

    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    User registrationRequestToUser(RegistrationRequest registrationRequest);
}
