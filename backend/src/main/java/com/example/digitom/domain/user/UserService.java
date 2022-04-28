package com.example.digitom.domain.user;

import com.example.digitom.service.registration.RegistrationRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRepository userRepository;

    public void addNewUser(RegistrationRequest registrationRequest) {

        User user = userMapper.registrationRequestToUser(registrationRequest);
        userRepository.save(user);
    }

}
