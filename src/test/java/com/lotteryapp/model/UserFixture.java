package com.lotteryapp.model;

public class UserFixture {
    private String username = "a-username";

    public UserFixture withUsername(String username) {
        this.username = username;
        return this;
    }

    public User build() {
        User user = new User();
        user.setUsername(username);
        return user;
    }
}
