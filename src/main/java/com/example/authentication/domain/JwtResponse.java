package com.example.authentication.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class JwtResponse {
    private final String responseToken;

    public JwtResponse(String responseToken) {
        this.responseToken = responseToken;
    }
}
