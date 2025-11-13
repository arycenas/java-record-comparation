package com.personal.recordcomparation.controllers;

import com.personal.recordcomparation.dtos.BuilderDto;
import com.personal.recordcomparation.dtos.DataDto;
import com.personal.recordcomparation.dtos.RecordDto;
import com.personal.recordcomparation.services.ComparationService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/compare")
public class ComparationController {

    private final ComparationService comparationService;

    @PostMapping("/builder")
    public BuilderDto builderCompare(@RequestBody BuilderDto request) {
        return comparationService.registerUserUsingBuilder(request);
    }

    @PostMapping("/data")
    public DataDto dataCompare(@RequestBody DataDto request) {
        return comparationService.registerUserUsingData(request);
    }

    @PostMapping("/record")
    public RecordDto recordCompare(@RequestBody RecordDto request) {
        return comparationService.registerUserUsingRecord(request);
    }
}
