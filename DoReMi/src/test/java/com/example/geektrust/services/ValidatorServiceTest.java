package com.example.geektrust.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorServiceTest {

    @Test
    void testIsValidSubCategory() {
        assertTrue(ValidatorService.isValidSubCategory("MUSIC"));
    }

    @Test
    void testIsValidSubType() {
        assertTrue(ValidatorService.isValidSubType("PREMIUM"));
    }

    @Test
    void testIsValidTopUp() {
        assertTrue(ValidatorService.isValidTopUp("TEN_DEVICE"));
    }
}
