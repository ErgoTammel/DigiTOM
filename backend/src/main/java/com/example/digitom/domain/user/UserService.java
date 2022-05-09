package com.example.digitom.domain.user;

import com.example.digitom.service.account.LoginRequest;
import com.example.digitom.service.account.RegistrationRequest;
import com.example.digitom.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRepository userRepository;

    @Resource
    private ValidationService validationService;

    public User addNewUser(RegistrationRequest registrationRequest) {
        User user = userMapper.registrationRequestToUser(registrationRequest);
        userRepository.save(user);
        return user;
    }

    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User getValidUser(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        validationService.userExist(user);
        return user.get();
    }
}
