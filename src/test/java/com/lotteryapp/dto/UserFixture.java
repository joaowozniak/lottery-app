package com.lotteryapp.dto;

public class UserFixture {
    private String username = "a-username";

    public UserFixture withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserDto build() {
        var userDto = UserDto.builder()
                .username(username)
                .build();
        return userDto;
    }
}
