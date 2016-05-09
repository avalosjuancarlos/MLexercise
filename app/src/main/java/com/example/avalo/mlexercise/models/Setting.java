package com.example.avalo.mlexercise.models;

import javax.annotation.Generated;

import com.example.avalo.mlexercise.utils.Constants.PaymentMethod;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Setting {

    @SerializedName(PaymentMethod.Setting.BIN)
    @Expose
    private Bin bin;
    @SerializedName(PaymentMethod.Setting.CARD_NUMBER)
    @Expose
    private CardNumber cardNumber;
    @SerializedName(PaymentMethod.Setting.SECURITY_CODE)
    @Expose
    private SecurityCode securityCode;

    /**
     * @return The bin
     */
    public Bin getBin() {
        return bin;
    }

    /**
     * @param bin The bin
     */
    public void setBin(Bin bin) {
        this.bin = bin;
    }

    /**
     * @return The cardNumber
     */
    public CardNumber getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber The card_number
     */
    public void setCardNumber(CardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @return The securityCode
     */
    public SecurityCode getSecurityCode() {
        return securityCode;
    }

    /**
     * @param securityCode The security_code
     */
    public void setSecurityCode(SecurityCode securityCode) {
        this.securityCode = securityCode;
    }

}