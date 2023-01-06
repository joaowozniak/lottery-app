package com.lotteryapp.service;

import com.lotteryapp.dto.RequestUserDto;
import com.lotteryapp.dto.UserDto;
import com.lotteryapp.repository.UserEntity;
import com.lotteryapp.repository.UserRepository;

public class UserRegistrationService {

    private UserRepository userRepository;

    public UserRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto registerUser(RequestUserDto requestUserDto) {
        var userEntity = requestUserDtoToEntity(requestUserDto);
        userRepository.save(userEntity);

        var userDto = UserDto.builder()
                .username(userEntity.getUsername())
                .build();
        return userDto;
    }

    protected UserEntity requestUserDtoToEntity(RequestUserDto requestUserDto) {
        var userEntity = new UserEntity();
        userEntity.setUsername(requestUserDto.getUsername());
        return userEntity;
    }
}
