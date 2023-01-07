package com.lotteryapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lotteryapp.dto.RequestUserDto;
import com.lotteryapp.dto.UserDto;
import com.lotteryapp.service.UserRegistrationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserRegistrationService userRegistrationService;

    @Test
    public void createUserSucceeds() throws Exception {
        //given a valid user registration request
        var requestUserDto = RequestUserDto.builder()
                .username("username")
                .build();

        var userDto = UserDto.builder()
                .username("username")
                .build();

        when(userRegistrationService.registerUser(requestUserDto)).thenReturn(userDto);

        //when registering a new user
        var result = mockMvc.perform(post("/v1/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestUserDto)))
                .andExpect(status().isCreated())
                .andReturn();

        //then expect user registered
        var userResponse = objectMapper.readValue(result.getResponse().getContentAsString(), UserDto.class);
        assertEquals(userDto, userResponse);
    }
}