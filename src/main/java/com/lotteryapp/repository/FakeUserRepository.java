package com.lotteryapp.repository;

import com.lotteryapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeUserRepository {

    List<User> users = new ArrayList<>();

    public List<User> allUsers() {
        return users;
    }

    public void register(User user) {
        users.add(user);
    }
}
