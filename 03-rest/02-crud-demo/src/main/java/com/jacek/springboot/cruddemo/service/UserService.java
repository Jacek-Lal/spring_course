package com.jacek.springboot.cruddemo.service;

import com.jacek.springboot.cruddemo.model.User;
import jakarta.transaction.Transactional;


import java.util.List;

public interface UserService {
    @Transactional
    User add(User user);

    List<User> getAll();

    User getById(Long id);

    @Transactional
    User update(Long id, User updatedUser);

    @Transactional
    void delete(Long id);

    @Transactional
    User patch(Long id, User user);
}
