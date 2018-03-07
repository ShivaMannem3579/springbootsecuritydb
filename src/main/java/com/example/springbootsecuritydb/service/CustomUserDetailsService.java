package com.example.springbootsecuritydb.service;

import com.example.springbootsecuritydb.model.CustomUserDetails;
import com.example.springbootsecuritydb.model.User;
import com.example.springbootsecuritydb.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByName(userName);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUser.map(CustomUserDetails :: new).get();
    }
}
