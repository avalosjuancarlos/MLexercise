package com.example.avalo.mlexercise.models;

import javax.annotation.Generated;

import com.example.avalo.mlexercise.utils.Constants.PaymentMethod.Setting;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CardNumber {

    @SerializedName(Setting.CardNumber.LENGTH)
    @Expose
    private Integer length;
    @SerializedName(Setting.CardNumber.VALIDATION)
    @Expose
    private String validation;

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
     * @return The validation
     */
    public String getValidation() {
        return validation;
    }

    /**
     * @param validation The validation
     */
    public void setValidation(String validation) {
        this.validation = validation;
    }

}
