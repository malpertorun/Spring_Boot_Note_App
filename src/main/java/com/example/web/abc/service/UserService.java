package com.example.web.abc.service;

import com.example.web.abc.domain.User;
import com.example.web.abc.domain.Item;
import java.util.List;
import java.util.Map;



public interface UserService {
    User getUserById(long id);

    User getUserByUsername(String username);

    User addUser(User user);

    Iterable<User> getUsers();

    Map<String, List<Item>> numberOfItemsByType(long userId);

    List<String> getUsernames();
}
