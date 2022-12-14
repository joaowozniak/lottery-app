package com.lotteryapp.repository;

import com.lotteryapp.model.User;

import com.lotteryapp.model.UserFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepositoryShould {

    private FakeUserRepository fakeUserRepository;

    @BeforeEach
    public void initialise() {
        fakeUserRepository = new FakeUserRepository();
    }

    @Test
    public void create_and_store_a_user_registration() {
        User user = new UserFixture().withUsername("a-username").build();
        fakeUserRepository.register(user);
        List<User> users = fakeUserRepository.allUsers();
        assertEquals(1, users.size());
        assertEquals(user, users.get(0));
    }

}
