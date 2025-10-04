package com.shridhar.production.production.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponceDto {

    long id;
    String accessToken;
    String refreshToken;
}
