package com.mk.recipeproject.service.user;

import com.mk.recipeproject.model.user.User;

public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);
}
