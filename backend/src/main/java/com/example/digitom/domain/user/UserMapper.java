package com.example.digitom.domain.user;

import com.example.digitom.service.account.RegistrationRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto userDto);

    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    User registrationRequestToUser(RegistrationRequest registrationRequest);


}
