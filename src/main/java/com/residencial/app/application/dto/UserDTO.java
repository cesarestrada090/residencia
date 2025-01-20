package com.residencial.app.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Integer id;
    private String name;
    private String lastName;
    private String username;
    private String document;
    private Boolean status;
    private String userType;
    private String password;
}