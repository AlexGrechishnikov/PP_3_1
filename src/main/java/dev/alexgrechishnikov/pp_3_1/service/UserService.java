package dev.alexgrechishnikov.pp_3_1.service;

import dev.alexgrechishnikov.pp_3_1.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User get(long id);
    void update(User user);
    void delete(long id);
    List<User> getUsersList();
}
