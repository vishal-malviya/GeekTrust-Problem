package com.example.geektrust.model;

import com.example.geektrust.enums.SubCategoryEnum;
import com.example.geektrust.enums.SubTypeEnum;
import com.example.geektrust.enums.TopUpEnum;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Vishal Malviya
 */
@Data
public abstract class UserSubscription {

    @NonNull
    public Date subscriptionDate;
    @NonNull
    private List<SubCategoryEnum> subscriptionCategory = new ArrayList<>();
    @NonNull
    private List<SubTypeEnum> subscriptionType = new ArrayList<>();
    private TopUpEnum topUp;
    private int topUpMonths;
    private int topUpcount = 0;
    private String errorString ="";

    public void addErrorString(String errorString) {
        this.errorString += errorString+"\n";
    }


    public UserSubscription() {

    }

    public void startSubscription(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public void addSubScription(SubCategoryEnum subscriptionCategory, SubTypeEnum subscriptionType) {
        this.subscriptionCategory.add(subscriptionCategory);
        this.subscriptionType.add(subscriptionType);

    }


    public abstract String getOutPut();

    public void addTopUp(
            @NonNull TopUpEnum topUp,
            @NonNull Integer topUpMonths) {
        this.topUp = topUp;
        this.topUpMonths = topUpMonths;
        this.topUpcount += 1;
    }

    public boolean isInitializedBillableCommunity() {
        return Objects.nonNull(subscriptionCategory)
                && Objects.nonNull(subscriptionType);
    }


}
