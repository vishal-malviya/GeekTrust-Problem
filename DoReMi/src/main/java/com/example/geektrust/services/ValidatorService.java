package com.example.geektrust.services;

import com.example.geektrust.enums.SubCategoryEnum;
import com.example.geektrust.enums.SubTypeEnum;
import com.example.geektrust.enums.TopUpEnum;


public class ValidatorService {

    public static boolean isValidSubCategory(String test) {

        for (SubCategoryEnum c : SubCategoryEnum.values()) {
            if (c.name().equals(test)) {
                return true;

            }
        }
        return false;
    }

    public static boolean isValidSubType(String test ) {

        for (SubTypeEnum c : SubTypeEnum.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }

        return false;
    }
    public static boolean isValidTopUp(String test ) {
        for (TopUpEnum c : TopUpEnum.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
