package com.example.avalo.mlexercise.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.example.avalo.mlexercise.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class PaymentMethod {

    @SerializedName(Constants.PaymentMethod.ID)
    @Expose
    private String id;
    @SerializedName(Constants.PaymentMethod.NAME)
    @Expose
    private String name;
    @SerializedName(Constants.PaymentMethod.PAYMENT_TYPE_ID)
    @Expose
    private String paymentTypeId;
    @SerializedName(Constants.PaymentMethod.STATUS)
    @Expose
    private String status;
    @SerializedName(Constants.PaymentMethod.SECURE_THUMBNAIL)
    @Expose
    private String secureThumbnail;
    @SerializedName(Constants.PaymentMethod.THUMBNAIL)
    @Expose
    private String thumbnail;
    @SerializedName(Constants.PaymentMethod.DEFERRED_CAPTURE)
    @Expose
    private String deferredCapture;
    @SerializedName(Constants.PaymentMethod.SETTINGS)
    @Expose
    private List<Setting> settings = new ArrayList<Setting>();
    @SerializedName(Constants.PaymentMethod.ADDITIONAL_INFO_NEEDED)
    @Expose
    private List<String> additionalInfoNeeded = new ArrayList<String>();
    @SerializedName(Constants.PaymentMethod.MIN_ALLOWED_AMOUNT)
    @Expose
    private Integer minAllowedAmount;
    @SerializedName(Constants.PaymentMethod.MAX_ALLOWED_AMOUNT)
    @Expose
    private Integer maxAllowedAmount;
    @SerializedName(Constants.PaymentMethod.ACCREDITATION_TIME)
    @Expose
    private Integer accreditationTime;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
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
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The secureThumbnail
     */
    public String getSecureThumbnail() {
        return secureThumbnail;
    }

    /**
     * @param secureThumbnail The secure_thumbnail
     */
    public void setSecureThumbnail(String secureThumbnail) {
        this.secureThumbnail = secureThumbnail;
    }

    /**
     * @return The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * @return The deferredCapture
     */
    public String getDeferredCapture() {
        return deferredCapture;
    }

    /**
     * @param deferredCapture The deferred_capture
     */
    public void setDeferredCapture(String deferredCapture) {
        this.deferredCapture = deferredCapture;
    }

    /**
     * @return The settings
     */
    public List<Setting> getSettings() {
        return settings;
    }

    /**
     * @param settings The settings
     */
    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    /**
     * @return The additionalInfoNeeded
     */
    public List<String> getAdditionalInfoNeeded() {
        return additionalInfoNeeded;
    }

    /**
     * @param additionalInfoNeeded The additional_info_needed
     */
    public void setAdditionalInfoNeeded(List<String> additionalInfoNeeded) {
        this.additionalInfoNeeded = additionalInfoNeeded;
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
     * @return The accreditationTime
     */
    public Integer getAccreditationTime() {
        return accreditationTime;
    }

    /**
     * @param accreditationTime The accreditation_time
     */
    public void setAccreditationTime(Integer accreditationTime) {
        this.accreditationTime = accreditationTime;
    }

}
