package com.lotteryapp.acceptance;

import com.lotteryapp.model.UserFixture;
import com.lotteryapp.service.UserRegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserShould {

    private UserRegistrationService userRegistrationService;

    @BeforeEach
    public void initialise() {
        userRegistrationService = new UserRegistrationService();
    }

    @Test
    public void givenNotRegisteredUser_whenUserRegisters_then200IsReceived() {
        var user = new UserFixture().withUsername("a-username").build();
        assertTrue(userRegistrationService.registerUser(user));
    }

}
