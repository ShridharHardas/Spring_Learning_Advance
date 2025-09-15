package com.shridhar.production.production.service;

import com.shridhar.production.production.dto.LoginDto;
import com.shridhar.production.production.dto.SignUpDto;
import com.shridhar.production.production.dto.UserDto;
import com.shridhar.production.production.entity.User;
import com.shridhar.production.production.exception.ResourceNotFoundException;
import com.shridhar.production.production.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         return userRepo.findByEmail(username)
                 .orElseThrow(()->new ResourceNotFoundException("User Name is Not Found :"+username));

    }

    public UserDto sighUp(SignUpDto signUpDto) {
        Optional<User> user=userRepo.findByEmail(signUpDto.getEmail());
        if(user.isPresent())
        {
            throw new BadCredentialsException("User are already Present Email :"+signUpDto.getEmail());
        }
        User usertoCreated =modelMapper.map(signUpDto, User.class);
        usertoCreated.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        User savedUser=userRepo.save(usertoCreated);
        return modelMapper.map(savedUser,UserDto.class);

    }




}
