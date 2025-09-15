package com.shridhar.production.production.controller;

import com.shridhar.production.production.dto.LoginDto;
import com.shridhar.production.production.dto.SignUpDto;
import com.shridhar.production.production.dto.UserDto;
import com.shridhar.production.production.service.AuthService;
import com.shridhar.production.production.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto)
    {
    String token=authService.login(loginDto);
    return ResponseEntity.ok(token);
    }
}
