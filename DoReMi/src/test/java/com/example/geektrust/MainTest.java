package com.example.geektrust;

import com.example.geektrust.exception.CustomExceptionHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    @Test
    void testMain() throws Exception {
        // Setup

        // Run the test
        Main.main(new String[]{"input1.txt"});

        // Verify the results
    }

}
