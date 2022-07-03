package com.example.geektrust.services;

import com.example.geektrust.enums.SubCategoryEnum;
import com.example.geektrust.enums.SubTypeEnum;
import com.example.geektrust.exception.CustomExceptionHandler;
import com.example.geektrust.model.Arguments;
import com.example.geektrust.model.UserSubscriptionManagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FileProcessorServiceTest {

    private FileProcessorService fileProcessorServiceUnderTest;
    private UserSubscriptionManagement userSubscriptionManagementUnderTest;

    @BeforeEach
    void setUp() throws FileNotFoundException {

        fileProcessorServiceUnderTest = new FileProcessorService("input1.txt");
    }

   /* @Test
    void testGetCommandsFromFile() {
        // Setup
        userSubscriptionManagementUnderTest = new UserSubscriptionManagement();
        userSubscriptionManagementUnderTest.setSubscriptionDate(new Date());
        userSubscriptionManagementUnderTest.setSubscriptionCategory(Arrays.asList(SubCategoryEnum.MUSIC));
        userSubscriptionManagementUnderTest.setSubscriptionType(Arrays.asList(SubTypeEnum.PERSONAL));
        // Run the test
        final List<Arguments> result = fileProcessorServiceUnderTest.getCommandsFromFile();

        // Verify the results
    }*/

    @Test
    void testGetCommandsFromFile_ThrowsCustomExceptionHandler() {
        // Setup

        // Run the test
        assertThrows(CustomExceptionHandler.class, () -> fileProcessorServiceUnderTest.getCommandsFromFile());
    }
}
