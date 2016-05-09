package com.example.avalo.mlexercise.models;

import javax.annotation.Generated;

import com.example.avalo.mlexercise.utils.Constants.PaymentMethod.Setting;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class SecurityCode {

    @SerializedName(Setting.SecurityCode.MODE)
    @Expose
    private String mode;
    @SerializedName(Setting.SecurityCode.LENGTH)
    @Expose
    private Integer length;
    @SerializedName(Setting.SecurityCode.CARD_LOCATION)
    @Expose
    private String cardLocation;

    /**
     * @return The mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * @param mode The mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * @return The length
     */
    public Integer getLength() {
        return length;
    }

    /**
     * @param length The length
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * @return The cardLocation
     */
    public String getCardLocation() {
        return cardLocation;
    }

    /**
     * @param cardLocation The card_location
     */
    public void setCardLocation(String cardLocation) {
        this.cardLocation = cardLocation;
    }

}
