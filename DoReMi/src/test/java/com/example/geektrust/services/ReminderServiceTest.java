package com.example.geektrust.services;

import com.example.geektrust.exception.CustomExceptionHandler;
import com.example.geektrust.model.UserSubscriptionManagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ReminderServiceTest {

    private ReminderService reminderServiceUnderTest;

    @BeforeEach
    void setUp() {
        reminderServiceUnderTest = ReminderService.getInstance();
    }

    @Test
    void testProcessOperation() {
        // Setup
        final UserSubscriptionManagement userSubscriptionManagement = new UserSubscriptionManagement();

        // Run the test
        final String result = reminderServiceUnderTest.processOperation(Arrays.asList("10-02-2022"), userSubscriptionManagement);

        // Verify the results
        assertNull(result);
    }

    @Test
    void testGetInstance() {
        // Setup

        // Run the test
        final ReminderService result = ReminderService.getInstance();

        // Verify the results
    }
}
