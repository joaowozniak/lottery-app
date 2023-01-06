package com.lotteryapp.service;

import com.lotteryapp.dto.RequestUserDto;
import com.lotteryapp.repository.UserEntity;
import com.lotteryapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserRegistrationServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserRegistrationService userRegistrationService;

    @Test
    public void givenValidRequestUserDto_whenUserRegisters_thenUserSavedCorrectly() {
        //given a valid UserRequestDto
        var requestUserDto = RequestUserDto.builder()
                .username("username")
                .build();

        //and expected entity saved
        when(userRepository.save(any(UserEntity.class))).thenReturn(userRegistrationService.requestUserDtoToEntity(requestUserDto));

        //when creating user
        var createdUser = userRegistrationService.registerUser(requestUserDto);

        //then expect the user saved correctly
        ArgumentCaptor<UserEntity> userEntityArgumentCaptor = ArgumentCaptor.forClass(UserEntity.class);
        verify(userRepository).save(userEntityArgumentCaptor.capture());

        var savedUser = userEntityArgumentCaptor.getValue();
        assertEquals(requestUserDto.getUsername(), savedUser.getUsername());
        assertEquals(savedUser.getUsername(), createdUser.getUsername());
    }

}