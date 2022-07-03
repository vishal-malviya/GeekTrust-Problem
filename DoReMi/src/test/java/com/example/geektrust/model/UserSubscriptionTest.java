package com.example.geektrust.model;

import com.example.geektrust.enums.SubCategoryEnum;
import com.example.geektrust.enums.SubTypeEnum;
import com.example.geektrust.enums.TopUpEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserSubscriptionTest {

    private UserSubscription userSubscriptionUnderTest;
    private UserSubscriptionManagement userSubscriptionManagement;

    @BeforeEach
    void setUp() {
        userSubscriptionUnderTest = new UserSubscription() {
            @Override
            public String getOutPut() {
                return null;
            }
        };
        userSubscriptionManagement = new UserSubscriptionManagement();
        userSubscriptionManagement.setSubscriptionDate(new Date());
        userSubscriptionManagement.setSubscriptionCategory(Arrays.asList(SubCategoryEnum.MUSIC));
        userSubscriptionManagement.setSubscriptionType(Arrays.asList(SubTypeEnum.PERSONAL));
        userSubscriptionManagement.setTopUp(TopUpEnum.TEN_DEVICE);
        userSubscriptionManagement.setTopUpMonths(3);
    }

    @Test
    void testAddErrorString() {
        // Setup

        // Run the test
        userSubscriptionUnderTest.addErrorString("errorString");

        // Verify the results
    }

    @Test
    void testStartSubscription() {
        // Setup

        // Run the test
        userSubscriptionUnderTest.startSubscription(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Verify the results
    }

    @Test
    void testAddSubScription() {
        // Setup

        // Run the test
        userSubscriptionUnderTest.addSubScription(SubCategoryEnum.MUSIC, SubTypeEnum.PREMIUM);

        // Verify the results
    }

    @Test
    void testAddTopUp() {
        // Setup

        // Run the test
        userSubscriptionUnderTest.addTopUp(TopUpEnum.FOUR_DEVICE, 0);

        // Verify the results
    }

    @Test
    void testIsInitializedBillableCommunity() {
        // Setup

        // Run the test
        final boolean result = userSubscriptionUnderTest.isInitializedBillableCommunity();

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testEquals() {
        // Setup


        // Run the test
        final boolean result = userSubscriptionUnderTest.equals(userSubscriptionUnderTest);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testHashCode() {
        // Setup

        // Run the test
        final int result = userSubscriptionUnderTest.hashCode();

        // Verify the results
        assertEquals(userSubscriptionUnderTest.hashCode(), result);
    }

    @Test
    void testToString() {
        // Setup

        // Run the test
        final String result = userSubscriptionUnderTest.toString();

        // Verify the results
        assertEquals(userSubscriptionUnderTest.toString(), result);
    }

    @Test
    void testCanEqual() {
        // Setup

        // Run the test
        final boolean result = userSubscriptionUnderTest.canEqual(userSubscriptionUnderTest);

        // Verify the results
        assertTrue(result);
    }
}
