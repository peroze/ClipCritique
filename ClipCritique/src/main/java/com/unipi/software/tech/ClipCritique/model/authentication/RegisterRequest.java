package com.unipi.software.tech.ClipCritique.model.authentication;

import lombok.*;
import com.unipi.software.tech.ClipCritique.model.Role;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest {

    private Long id;
    private String fullName;
    private String password;
    private String email;
    private LocalDate dateOfBirth;


}
