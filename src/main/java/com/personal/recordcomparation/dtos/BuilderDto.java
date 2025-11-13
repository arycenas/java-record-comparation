package com.personal.recordcomparation.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuilderDto {

    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private int age;
}
