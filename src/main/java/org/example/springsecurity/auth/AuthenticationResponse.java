package org.example.springsecurity.auth;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AuthenticationResponse {
    private String token;
}
