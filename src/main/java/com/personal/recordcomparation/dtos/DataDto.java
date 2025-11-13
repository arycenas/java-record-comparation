package com.personal.recordcomparation.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataDto {

    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private int age;
}
