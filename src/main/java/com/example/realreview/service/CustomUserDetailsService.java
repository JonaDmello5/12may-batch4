package com.example.realreview.service;

import com.example.realreview.config.CustomerUserDetails;
import com.example.realreview.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(CustomerUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
