package com.unipi.software.tech.ClipCritique.model.authentication;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginRequest {

    private String email;
    private String password;

}
