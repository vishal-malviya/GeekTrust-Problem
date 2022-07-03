package com.example.geektrust.services;

import com.example.geektrust.enums.SubCategoryEnum;
import com.example.geektrust.enums.SubTypeEnum;
import com.example.geektrust.model.UserSubscriptionManagement;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vishal Malviya
 */
public class SubCategoryService implements ExecutionService {
    @Getter
    private static final SubCategoryService instance = new SubCategoryService();

    private SubCategoryService() {
    }

    @Override
    public String processOperation(List<String> arguments, UserSubscriptionManagement userSubscriptionManagement) {
        String subCat = arguments.get(0);
        String subType = arguments.get(1);
        if (!userSubscriptionManagement.getErrorString().isEmpty()) {
            userSubscriptionManagement.addErrorString("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
        } else if (userSubscriptionManagement.getSubscriptionCategory() != null && userSubscriptionManagement.getSubscriptionCategory().stream().distinct().collect(Collectors.toList()).contains(SubCategoryEnum.valueOf(subCat))) {
            userSubscriptionManagement.addErrorString("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
        } else if (ValidatorService.isValidSubCategory(subCat) && ValidatorService.isValidSubType(subType)) {
            userSubscriptionManagement.addSubScription(SubCategoryEnum.valueOf(subCat), SubTypeEnum.valueOf(subType));
        } else {
            userSubscriptionManagement.addErrorString("SUBSCRIPTION_NOT_FOUND");
        }
        return null;
    }

}
