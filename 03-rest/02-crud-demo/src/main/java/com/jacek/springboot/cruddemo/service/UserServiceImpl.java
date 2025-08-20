package com.jacek.springboot.cruddemo.service;

import com.jacek.springboot.cruddemo.model.User;
import com.jacek.springboot.cruddemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getRoles().toArray(new String[0]))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(!user.isEnabled())
                .build();
    }

    @Override
    public User add(User user) {
        return repository.save(new User(user.getUsername(), user.getPassword(), user.isEnabled(), user.getRoles()));
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User update(Long id, User updatedUser) {
        return null;
    }

    @Override
    public void delete(Long id) {}

    @Override
    public User patch(Long id, User user) {
        return null;
    }
}
