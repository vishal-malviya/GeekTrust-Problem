package com.example.geektrust.services;

import com.example.geektrust.enums.SubCategoryEnum;
import com.example.geektrust.enums.SubTypeEnum;
import com.example.geektrust.enums.TopUpEnum;
import com.example.geektrust.model.UserSubscriptionManagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TopUpServiceTest {

    private TopUpService topUpServiceUnderTest;
    private UserSubscriptionManagement userSubscriptionManagementUnderTest;

    @BeforeEach
    void setUp() {
        topUpServiceUnderTest = TopUpService.getInstance();
        userSubscriptionManagementUnderTest = new UserSubscriptionManagement();
        userSubscriptionManagementUnderTest.setSubscriptionDate(new Date());
        userSubscriptionManagementUnderTest.setSubscriptionCategory(Arrays.asList(SubCategoryEnum.MUSIC));
        userSubscriptionManagementUnderTest.setSubscriptionType(Arrays.asList(SubTypeEnum.PERSONAL));
    }

    @Test
    void testProcessOperation() {
        // Setup
        // Run the test
        final String result = topUpServiceUnderTest.processOperation(Arrays.asList("TEN_DEVICE","2"), userSubscriptionManagementUnderTest);

        // Verify the results
        assertEquals(null, result);
    }


    @Test
    void testGetInstance() {
        // Setup

        // Run the test
        final TopUpService result = TopUpService.getInstance();

        // Verify the results
    }
}
