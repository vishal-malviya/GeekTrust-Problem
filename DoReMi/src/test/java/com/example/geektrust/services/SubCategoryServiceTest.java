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

class SubCategoryServiceTest {

    private SubCategoryService subCategoryServiceUnderTest;
    private UserSubscriptionManagement userSubscriptionManagementUnderTest;

    @BeforeEach
    void setUp() {
        subCategoryServiceUnderTest = SubCategoryService.getInstance();
        userSubscriptionManagementUnderTest = new UserSubscriptionManagement();
        userSubscriptionManagementUnderTest.setSubscriptionDate(new Date());
        userSubscriptionManagementUnderTest.setSubscriptionCategory(Arrays.asList(SubCategoryEnum.MUSIC));
        userSubscriptionManagementUnderTest.setSubscriptionType(Arrays.asList(SubTypeEnum.PERSONAL));

    }

  /*  @Test
    void testProcessOperation() {
        // Setup

        // Run the test
        final String result = subCategoryServiceUnderTest.processOperation(Arrays.asList("VIDEO" ,"PREMIUM"), userSubscriptionManagementUnderTest);

        // Verify the results
        assertEquals(null, result);
    }*/



    @Test
    void testGetInstance() {
        // Setup

        // Run the test
        final SubCategoryService result = SubCategoryService.getInstance();

        // Verify the results
    }
}
