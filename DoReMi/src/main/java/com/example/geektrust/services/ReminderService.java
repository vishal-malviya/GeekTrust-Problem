package com.example.geektrust.services;

import com.example.geektrust.model.UserSubscriptionManagement;
import lombok.Getter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Vishal Malviya
 */
public class ReminderService implements ExecutionService {
    @Getter
    private static final ReminderService instance = new ReminderService();

    private ReminderService() {
    }

    @Override
    public String processOperation(List<String> arguments, UserSubscriptionManagement userSubscriptionManagement) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        String subscriptionDate = arguments.get(0);
        try {
            if (dateFormat.format(dateFormat.parse(subscriptionDate)).equals(subscriptionDate)) {
                userSubscriptionManagement.startSubscription(dateFormat.parse(subscriptionDate));
            } else {
                userSubscriptionManagement.addErrorString("INVALID_DATE");
            }
        } catch (ParseException e) {
            userSubscriptionManagement.addErrorString("INVALID_DATE");
        }
        return null;
    }
}
