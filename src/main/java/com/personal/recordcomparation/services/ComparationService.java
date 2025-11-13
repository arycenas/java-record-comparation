package com.personal.recordcomparation.services;

import com.personal.recordcomparation.dtos.BuilderDto;
import com.personal.recordcomparation.dtos.DataDto;
import com.personal.recordcomparation.dtos.RecordDto;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Slf4j
@Service
public class ComparationService {

    public BuilderDto registerUserUsingBuilder(BuilderDto request) {
        return measure(
                "BUILDER",
                () ->
                        BuilderDto.builder()
                                .username(request.getUsername())
                                .email(request.getEmail())
                                .password(request.getPassword())
                                .firstname(request.getFirstname())
                                .lastname(request.getLastname())
                                .age(request.getAge())
                                .build());
    }

    public DataDto registerUserUsingData(DataDto request) {
        return measure(
                "DATA",
                () ->
                        new DataDto(
                                request.getUsername(),
                                request.getEmail(),
                                request.getPassword(),
                                request.getFirstname(),
                                request.getLastname(),
                                request.getAge()));
    }

    public RecordDto registerUserUsingRecord(RecordDto request) {
        return measure(
                "RECORD",
                () ->
                        new RecordDto(
                                request.username(),
                                request.email(),
                                request.password(),
                                request.firstname(),
                                request.lastname(),
                                request.age()));
    }

    private <T> T measure(String label, Supplier<T> supplier) {
        // Force garbage collection before measurement to reduce noice in memory usage result.
        System.gc();
        try {
            // Provides a short pause to allow GC thread to complete before measurement.
            Thread.sleep(100);
        } catch (InterruptedException _) {
            Thread.currentThread().interrupt();
        }

        long usedMemoryBefore =
                Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();

        T result = supplier.get();

        long endTime = System.nanoTime();
        long usedMemoryAfter =
                Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        log.info(
                "[{}] Time: {} ns | Memory: {} bytes",
                label,
                endTime - startTime,
                usedMemoryAfter - usedMemoryBefore);

        return result;
    }
}
