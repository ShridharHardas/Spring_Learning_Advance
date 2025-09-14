package com.shridhar.production.production.service;

import com.shridhar.production.production.exception.ResourceNotFoundException;
import com.shridhar.production.production.repository.UserRepo;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         return userRepo.findByEmail(username)
                 .orElseThrow(()->new ResourceNotFoundException("User Name is Not Found :"+username));

    }
}
