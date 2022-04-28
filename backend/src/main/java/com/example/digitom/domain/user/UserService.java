package com.example.digitom.domain.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRepository userRepository;

    public void addNewUser(UserDto userDto) {

        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
    }

}
