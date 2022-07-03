package com.example.geektrust.model;

import com.example.geektrust.enums.SubCategoryEnum;
import com.example.geektrust.enums.SubTypeEnum;
import com.example.geektrust.enums.TopUpEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserSubscriptionManagementTest {

    private UserSubscriptionManagement userSubscriptionManagementUnderTest;

    @BeforeEach
    void setUp() {
        userSubscriptionManagementUnderTest = new UserSubscriptionManagement();
        userSubscriptionManagementUnderTest.setSubscriptionDate(new Date());
        userSubscriptionManagementUnderTest.setSubscriptionCategory(Arrays.asList(SubCategoryEnum.MUSIC));
        userSubscriptionManagementUnderTest.setSubscriptionType(Arrays.asList(SubTypeEnum.PERSONAL));
        userSubscriptionManagementUnderTest.setTopUp(TopUpEnum.TEN_DEVICE);
        userSubscriptionManagementUnderTest.setTopUpMonths(3);

    }

    @Test
    void testGetOutPut() {
        // Setup

        // Run the test
        final String result = userSubscriptionManagementUnderTest.getOutPut();

        // Verify the results
        assertEquals("RENEWAL_REMINDER MUSIC 02-07-2022\n" +
                "RENEWAL_AMOUNT 400", result);
    }

    @Test
    void testCalculateTotalAmount() {
        // Setup

        // Run the test
        final String result = userSubscriptionManagementUnderTest.calculateTotalAmount();

        // Verify the results
        assertEquals("RENEWAL_REMINDER MUSIC 02-07-2022\n" +
                "RENEWAL_AMOUNT 400", result);
    }

    @Test
    void testConvertToLocalDateViaInstant() {
        // Setup

        // Run the test
        final LocalDate result = userSubscriptionManagementUnderTest.convertToLocalDateViaInstant(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Verify the results
        assertEquals(LocalDate.of(2020, 1, 1), result);
    }
}
