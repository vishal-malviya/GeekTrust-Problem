package com.example.geektrust.services;

import com.example.geektrust.enums.SubCategoryEnum;
import com.example.geektrust.enums.SubTypeEnum;
import com.example.geektrust.enums.TopUpEnum;
import com.example.geektrust.exception.CustomExceptionHandler;
import com.example.geektrust.model.UserSubscriptionManagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OutputServiceTest {

    private OutputService outputServiceUnderTest;

    @BeforeEach
    void setUp() {
        outputServiceUnderTest = OutputService.getInstance();

    }

    @Test
    void testProcessOperation() {
        // Setup
        final UserSubscriptionManagement userSubscriptionManagement =  new UserSubscriptionManagement();
        userSubscriptionManagement.setSubscriptionDate(new Date());
        userSubscriptionManagement.setSubscriptionCategory(Arrays.asList(SubCategoryEnum.MUSIC));
        userSubscriptionManagement.setSubscriptionType(Arrays.asList(SubTypeEnum.PERSONAL));
        userSubscriptionManagement.setTopUp(TopUpEnum.TEN_DEVICE);
        userSubscriptionManagement.setTopUpMonths(3);
        // Run the test
        final String result = outputServiceUnderTest.processOperation(Arrays.asList("value"), userSubscriptionManagement);

        // Verify the results
        assertEquals("RENEWAL_REMINDER MUSIC 02-07-2022\n" +
                "RENEWAL_AMOUNT 400", result);
    }

   /* @Test
    void testProcessOperation_ThrowsCustomExceptionHandler() {

        UserSubscriptionManagement userSubscriptionManagement = new UserSubscriptionManagement();
        userSubscriptionManagement.setSubscriptionDate(null);
        userSubscriptionManagement.setErrorString("INVALID_DATE");
        // Run the test
        assertThrows(NullPointerException.class, () -> outputServiceUnderTest.processOperation(Arrays.asList("PRINT_RENEWAL_DETAILS"), userSubscriptionManagement));
    }*/

    @Test
    void testGetInstance() {
        // Setup

        // Run the test
        final OutputService result = OutputService.getInstance();

        // Verify the results
    }
}
