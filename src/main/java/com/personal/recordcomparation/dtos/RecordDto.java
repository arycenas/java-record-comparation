package com.personal.recordcomparation.dtos;

public record RecordDto(
        String username,
        String email,
        String password,
        String firstname,
        String lastname,
        int age) {}
