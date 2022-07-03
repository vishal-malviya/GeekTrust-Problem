package com.example.geektrust.services;

import com.example.geektrust.enums.TopUpEnum;
import com.example.geektrust.model.UserSubscriptionManagement;
import lombok.Getter;

import java.util.List;

/**
 * @author Vishal Malviya
 */
public class TopUpService implements ExecutionService {
    @Getter
    private static final TopUpService instance = new TopUpService();

    private TopUpService() {
    }

    @Override
    public String processOperation(List<String> arguments, UserSubscriptionManagement userSubscriptionManagement) {
        String topUp = arguments.get(0);
        int topUpMonths = Integer.parseInt(arguments.get(1));
        if (!ValidatorService.isValidTopUp(topUp)) {
            userSubscriptionManagement.addErrorString("ADD_TOPUP_FAILED TOPUP NOT_FOUND");
        } else if (!userSubscriptionManagement.isInitializedBillableCommunity()) {
            if (!userSubscriptionManagement.getErrorString().isEmpty()) {
                userSubscriptionManagement.addErrorString("ADD_TOPUP_FAILED INVALID_DATE");
            }
            userSubscriptionManagement.addErrorString("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND SUBSCRIPTIONS_NOT_FOUND");
        } else if (userSubscriptionManagement.getTopUpcount() > 0) {
            userSubscriptionManagement.addErrorString("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
        } else {
            if (userSubscriptionManagement.getErrorString().contains("INVALID_DATE")) {
                userSubscriptionManagement.addErrorString("ADD_TOPUP_FAILED INVALID_DATE");
            }
            userSubscriptionManagement.addTopUp(TopUpEnum.valueOf(topUp), topUpMonths);
        }
        return null;
    }
}