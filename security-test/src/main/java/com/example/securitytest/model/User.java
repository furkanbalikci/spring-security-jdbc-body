package com.example.securitytest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first_name;
    private String last_name;
    private Integer age;
    private String roles;
    private String username;
    private String password;

    public User(String first_name, String last_name, Integer age, String roles, String username, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.roles = roles;
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(roles.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
