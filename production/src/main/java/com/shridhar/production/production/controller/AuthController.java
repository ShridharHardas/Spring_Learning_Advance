package com.shridhar.production.production.controller;

import com.shridhar.production.production.dto.LoginDto;
import com.shridhar.production.production.dto.LoginResponceDto;
import com.shridhar.production.production.dto.SignUpDto;
import com.shridhar.production.production.dto.UserDto;
import com.shridhar.production.production.exception.ResourceNotFoundException;
import com.shridhar.production.production.service.AuthService;
import com.shridhar.production.production.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signUp")
    public ResponseEntity<UserDto> sighUp(@RequestBody SignUpDto signUpDto) {
        UserDto userDto=userService.sighUp(signUpDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponceDto> login(@RequestBody LoginDto loginDto, HttpServletRequest request
                                                                        , HttpServletResponse response)
    {
    LoginResponceDto loginResponceDto=authService.login(loginDto);
    Cookie cookie=new Cookie("refreshToken",loginResponceDto.getRefreshToken());
    cookie.setHttpOnly(true);
    response.addCookie(cookie);
    return ResponseEntity.ok(loginResponceDto);
    }


    @PostMapping("/refresh")
    public ResponseEntity<LoginResponceDto> refresh(HttpServletRequest request) {
        String refreshToken=Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals("refreshToken"))
                .findFirst()
                .map(Cookie::getValue)
                .orElseThrow(()->new ResourceNotFoundException("Refresh Token Not Found"));
        LoginResponceDto loginResponceDto=authService.refreshToken(refreshToken);
        return ResponseEntity.ok(loginResponceDto);

    }
}
