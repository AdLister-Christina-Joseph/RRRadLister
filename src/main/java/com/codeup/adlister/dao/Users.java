package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);

    Long insert(User user);

    User findByUserID(Long id);

    boolean isUnique(String username);

    void updateUser(User user, String newUsername, String newEmail, String hash);
}
