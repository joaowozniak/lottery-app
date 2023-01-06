package com.lotteryapp.controller;

import com.lotteryapp.dto.RequestUserDto;
import com.lotteryapp.dto.UserDto;
import com.lotteryapp.service.UserRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    private UserRegistrationService userRegistrationService;

    public UserController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @RequestMapping("/v1/register")
    @PostMapping
    ResponseEntity<?> createUser(@RequestBody RequestUserDto requestUserDto) {
        //validate input data -> return list of errors
        UserDto userDto = userRegistrationService.registerUser(requestUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }
}
