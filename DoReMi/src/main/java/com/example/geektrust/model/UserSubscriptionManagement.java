package com.example.geektrust.model;

import com.example.geektrust.enums.SubCategoryEnum;
import com.example.geektrust.enums.SubTypeEnum;
import com.example.geektrust.enums.TopUpEnum;
import com.example.geektrust.exception.CustomExceptionHandler;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Vishal Malviya
 */
public class UserSubscriptionManagement extends UserSubscription {


    public static final String RENEWAL_REMINDER = "RENEWAL_REMINDER ";
    public static final int ZERO = 0;
    public static final int TWO_HUNDRED_FIFTY = 250;
    public static final int HUNDRED = 100;
    public static final int THREE_HUNDRED = 300;
    public static final int FIVE_HUNDRED = 500;
    public static final int TWO_HUNDRED = 200;
    public static final int FIFTY = 50;

    public UserSubscriptionManagement() {
        super();
    }

    @Override
    public String getOutPut() {
        return calculateTotalAmount();
    }

    public String calculateTotalAmount() {
        int totalAmount = ZERO;
        int count = ZERO;
        StringBuilder output = new StringBuilder("");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate subDate = convertToLocalDateViaInstant(getSubscriptionDate());
        addErrorToOutput(output);
        for (SubCategoryEnum s : getSubscriptionCategory()) {
            if (s.equals(SubCategoryEnum.MUSIC)) {
                totalAmount = addingMusicSub(totalAmount, count, output, dateTimeFormatter, subDate);
            }
            if (s.equals(SubCategoryEnum.PODCAST)) {
                totalAmount = addingPodcastSub(totalAmount, count, output, dateTimeFormatter, subDate);
            }
            if (s.equals(SubCategoryEnum.VIDEO)) {
                totalAmount = addingVideoSubScription(totalAmount, count, output, dateTimeFormatter, subDate);
            }
            count++;
        }
        totalAmount = getTotalAmountAfterAdingTopUp(totalAmount);

        output.append("RENEWAL_AMOUNT ").append(totalAmount);
        return output.toString();
    }

    private int addingMusicSub(int totalAmount, int count, StringBuilder output, DateTimeFormatter dateTimeFormatter, LocalDate subDate) {
        if (getSubscriptionType().get(count).equals(SubTypeEnum.PREMIUM)) {
            output.append(RENEWAL_REMINDER).append(SubCategoryEnum.MUSIC).append(subDate.plusMonths(3).minusDays(10).format(dateTimeFormatter)).append("\n");
            totalAmount = totalAmount + TWO_HUNDRED_FIFTY;
        } else if (getSubscriptionType().get(count).equals(SubTypeEnum.PERSONAL)) {
            output.append(RENEWAL_REMINDER + "MUSIC ").append(subDate.plusMonths(1).minusDays(10).format(dateTimeFormatter)).append("\n");
            totalAmount = totalAmount + HUNDRED;
        } else if (getSubscriptionType().get(count).equals(SubTypeEnum.FREE)) {
            output.append(RENEWAL_REMINDER + "MUSIC ").append(subDate.plusMonths(1).minusDays(10).format(dateTimeFormatter)).append("\n");
        }
        return totalAmount;
    }

    private int addingPodcastSub(int totalAmount, int count, StringBuilder output, DateTimeFormatter dateTimeFormatter, LocalDate subDate) {
        if (getSubscriptionType().get(count).equals(SubTypeEnum.PREMIUM)) {
            output.append(RENEWAL_REMINDER + SubCategoryEnum.PODCAST).append(subDate.plusMonths(3).minusDays(10).format(dateTimeFormatter)).append("\n");
            totalAmount = totalAmount + THREE_HUNDRED;
        } else if (getSubscriptionType().get(count).equals(SubTypeEnum.PERSONAL)) {
            output.append(RENEWAL_REMINDER + "PODCAST ").append(subDate.plusMonths(1).minusDays(10).format(dateTimeFormatter)).append("\n");
            totalAmount = totalAmount + HUNDRED;
        } else if (getSubscriptionType().get(count).equals(SubTypeEnum.FREE)) {
            output.append(RENEWAL_REMINDER + "PODCAST ").append(subDate.plusMonths(1).minusDays(10).format(dateTimeFormatter)).append("\n");
        }
        return totalAmount;
    }

    private int addingVideoSubScription(int totalAmount, int count, StringBuilder output, DateTimeFormatter dateTimeFormatter, LocalDate subDate) {
        if (getSubscriptionType().get(count).equals(SubTypeEnum.PREMIUM)) {
            output.append(RENEWAL_REMINDER + "VIDEO ").append(subDate.plusMonths(3).minusDays(10).format(dateTimeFormatter)).append("\n");
            totalAmount = totalAmount + FIVE_HUNDRED;
        } else if (getSubscriptionType().get(count).equals(SubTypeEnum.PERSONAL)) {
            output.append(RENEWAL_REMINDER + "VIDEO ").append(subDate.plusMonths(1).minusDays(10).format(dateTimeFormatter)).append("\n");
            totalAmount = totalAmount + TWO_HUNDRED;
        } else if (getSubscriptionType().get(count).equals(SubTypeEnum.FREE)) {
            output.append(RENEWAL_REMINDER + "VIDEO ").append(subDate.plusMonths(1).minusDays(10).format(dateTimeFormatter)).append("\n");
        }
        return totalAmount;
    }

    private void addErrorToOutput(StringBuilder output) {
        if (!getErrorString().isEmpty()) {
            output.append(getErrorString());
        }
    }


    private int getTotalAmountAfterAdingTopUp(int totalAmount) {
        if (getTopUp() != null) {
            if (getTopUp().equals(TopUpEnum.FOUR_DEVICE)) {
                totalAmount = totalAmount + FIFTY * (getTopUpMonths());
            } else if (getTopUp().equals(TopUpEnum.TEN_DEVICE)) {
                totalAmount = totalAmount + HUNDRED * (getTopUpMonths());
            }
        }
        return totalAmount;
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        LocalDate date = null;
        if (dateToConvert != null) {
            date = dateToConvert.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        } else {
            System.out.println(getErrorString() + "SUBSCRIPTIONS_NOT_FOUND");
            throw new CustomExceptionHandler("");
        }
        return date;
    }


}
