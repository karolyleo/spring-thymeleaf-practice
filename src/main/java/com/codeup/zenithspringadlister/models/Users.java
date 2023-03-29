package com.codeup.zenithspringadlister.models;

import com.codeup.zenithspringadlister.repository.UserRepository;

import java.util.List;
import java.util.Random;

public class Users {
    public static User randomUser(UserRepository usersDao){
        List<User> allUsers = usersDao.findAll();
        int randomInt = new Random().nextInt(allUsers.size());
        return allUsers.get(randomInt);
    }
}
