package com.shridhar.production.production.service;

import com.shridhar.production.production.dto.LoginDto;
import com.shridhar.production.production.dto.LoginResponceDto;
import com.shridhar.production.production.dto.UserDto;
import com.shridhar.production.production.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;

    public LoginResponceDto login(LoginDto loginDto) {
        Authentication authenticate =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
        User user=(User)authenticate.getPrincipal();
        String accessToken=jwtService.generateAccessToken(user);
        String refreshToken=jwtService.generateRefreshToken(user);
        return new LoginResponceDto(user.getId(), accessToken,refreshToken);
    }

    public LoginResponceDto refreshToken(String refreshToken) {
        Long userId=jwtService.getUserIdFromToken(refreshToken);
        User user=userService.getUserById(userId);
        String token=jwtService.generateAccessToken(user);
        return new LoginResponceDto(user.getId(), token,refreshToken);
    }
}
