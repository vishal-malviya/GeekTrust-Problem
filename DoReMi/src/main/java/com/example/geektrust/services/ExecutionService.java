package com.example.geektrust.services;

import com.example.geektrust.exception.CustomExceptionHandler;
import com.example.geektrust.model.UserSubscriptionManagement;

import java.util.List;

/**
 * @author Vishal Malviya
 */
public interface ExecutionService {
    String processOperation(List<String> arguments, UserSubscriptionManagement userSubscriptionManagement)
            throws CustomExceptionHandler;
}
