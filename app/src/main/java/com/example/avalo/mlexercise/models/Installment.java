package com.example.avalo.mlexercise.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.example.avalo.mlexercise.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Installment {

    @SerializedName(Constants.Installment.PAYMENT_METHOD_ID)
    @Expose
    private String paymentMethodId;
    @SerializedName(Constants.Installment.PAYMENT_TYPE_ID)
    @Expose
    private String paymentTypeId;
    @SerializedName(Constants.Installment.ISSUER)
    @Expose
    private Issuer issuer;
    @SerializedName(Constants.Installment.PAYER_COSTS)
    @Expose
    private List<PayerCost> payerCosts = new ArrayList<PayerCost>();

    /**
     * @return The paymentMethodId
     */
    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    /**
     * @param paymentMethodId The payment_method_id
     */
    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    /**
     * @return The paymentTypeId
     */
    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    /**
     * @param paymentTypeId The payment_type_id
     */
    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    /**
     * @return The issuer
     */
    public Issuer getIssuer() {
        return issuer;
    }

    /**
     * @param issuer The issuer
     */
    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    /**
     * @return The payerCosts
     */
    public List<PayerCost> getPayerCosts() {
        return payerCosts;
    }

    /**
     * @param payerCosts The payer_costs
     */
    public void setPayerCosts(List<PayerCost> payerCosts) {
        this.payerCosts = payerCosts;
    }

}
