package com.example.avalo.mlexercise.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.example.avalo.mlexercise.utils.Constants.Installment;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class PayerCost {

    @SerializedName(Installment.PayerCost.INSTALLMENTS)
    @Expose
    private Integer installments;
    @SerializedName(Installment.PayerCost.INSTALLMENT_RATE)
    @Expose
    private Integer installmentRate;
    @SerializedName(Installment.PayerCost.DISCOUNT_RATE)
    @Expose
    private Integer discountRate;
    @SerializedName(Installment.PayerCost.LABELS)
    @Expose
    private List<String> labels = new ArrayList<String>();
    @SerializedName(Installment.PayerCost.MIN_ALLOWED_AMOUNT)
    @Expose
    private Integer minAllowedAmount;
    @SerializedName(Installment.PayerCost.MAX_ALLOWED_AMOUNT)
    @Expose
    private Integer maxAllowedAmount;
    @SerializedName(Installment.PayerCost.RECOMMENDED_MESSAGE)
    @Expose
    private String recommendedMessage;
    @SerializedName(Installment.PayerCost.INSTALLMENT_AMOUNT)
    @Expose
    private Double installmentAmount;
    @SerializedName(Installment.PayerCost.TOTAL_AMOUNT)
    @Expose
    private Double totalAmount;

    /**
     * @return The installments
     */
    public Integer getInstallments() {
        return installments;
    }

    /**
     * @param installments The installments
     */
    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    /**
     * @return The installmentRate
     */
    public Integer getInstallmentRate() {
        return installmentRate;
    }

    /**
     * @param installmentRate The installment_rate
     */
    public void setInstallmentRate(Integer installmentRate) {
        this.installmentRate = installmentRate;
    }

    /**
     * @return The discountRate
     */
    public Integer getDiscountRate() {
        return discountRate;
    }

    /**
     * @param discountRate The discount_rate
     */
    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * @return The labels
     */
    public List<String> getLabels() {
        return labels;
    }

    /**
     * @param labels The labels
     */
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    /**
     * @return The minAllowedAmount
     */
    public Integer getMinAllowedAmount() {
        return minAllowedAmount;
    }

    /**
     * @param minAllowedAmount The min_allowed_amount
     */
    public void setMinAllowedAmount(Integer minAllowedAmount) {
        this.minAllowedAmount = minAllowedAmount;
    }

    /**
     * @return The maxAllowedAmount
     */
    public Integer getMaxAllowedAmount() {
        return maxAllowedAmount;
    }

    /**
     * @param maxAllowedAmount The max_allowed_amount
     */
    public void setMaxAllowedAmount(Integer maxAllowedAmount) {
        this.maxAllowedAmount = maxAllowedAmount;
    }

    /**
     * @return The recommendedMessage
     */
    public String getRecommendedMessage() {
        return recommendedMessage;
    }

    /**
     * @param recommendedMessage The recommended_message
     */
    public void setRecommendedMessage(String recommendedMessage) {
        this.recommendedMessage = recommendedMessage;
    }


    /**
     * @return The installmentAmount
     */
    public Double getInstallmentAmount() {
        return installmentAmount;
    }

    /**
     * @param installmentAmount The installment_amount
     */
    public void setInstallmentAmount(Double installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    /**
     * @return The totalAmount
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount The total_amount
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

}