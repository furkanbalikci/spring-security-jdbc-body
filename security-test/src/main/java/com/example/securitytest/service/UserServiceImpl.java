package com.example.securitytest.service;

import com.example.securitytest.model.User;
import com.example.securitytest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode(user.get().getPassword());

        if (user.isEmpty()){
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.get().getUsername())
                .password(pass)
                .authorities(Arrays.stream(user.get().getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList()))
                .build();
    }
}
