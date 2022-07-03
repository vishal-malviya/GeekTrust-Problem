package com.example.geektrust.services;

import com.example.geektrust.exception.CustomExceptionHandler;
import com.example.geektrust.model.UserSubscriptionManagement;
import lombok.Getter;

import java.util.List;

/**
 * @author Vishal Malviya
 */
public class OutputService implements ExecutionService {
    @Getter
    private static final OutputService instance = new OutputService();

    public OutputService() {
    }

    @Override
    public String processOperation(List<String> arguments, UserSubscriptionManagement userSubscriptionManagement) throws CustomExceptionHandler {
        return userSubscriptionManagement.getOutPut();
    }
}
