package com.jacek.springboot.cruddemo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean enabled;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    public User(String username, String password, boolean enabled, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }
}
