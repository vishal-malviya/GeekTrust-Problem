package com.example.geektrust.model;

import com.example.geektrust.services.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

/**
 * @author Vishal Malviya
 */
@RequiredArgsConstructor
@Getter
public enum Operator {
    START_SUBSCRIPTION(1, ReminderService::getInstance),
    ADD_SUBSCRIPTION(2, SubCategoryService::getInstance),
    ADD_TOPUP(2, TopUpService::getInstance),
    PRINT_RENEWAL_DETAILS(0, OutputService::getInstance);

    @NonNull
    private Integer numberOfArguments;
    @NonNull
    private Supplier<? extends ExecutionService> executionService;

}
