package com.example.avalo.mlexercise.models;

import javax.annotation.Generated;

import com.example.avalo.mlexercise.utils.Constants.PaymentMethod.Setting;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Bin {

    @SerializedName(Setting.Bin.PATTERN)
    @Expose
    private String pattern;
    @SerializedName(Setting.Bin.EXCLUSION_PATTERN)
    @Expose
    private String exclusionPattern;
    @SerializedName(Setting.Bin.INSTALLMENTS_PATTERN)
    @Expose
    private String installmentsPattern;

    /**
     * @return The pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param pattern The pattern
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * @return The exclusionPattern
     */
    public String getExclusionPattern() {
        return exclusionPattern;
    }

    /**
     * @param exclusionPattern The exclusion_pattern
     */
    public void setExclusionPattern(String exclusionPattern) {
        this.exclusionPattern = exclusionPattern;
    }

    /**
     * @return The installmentsPattern
     */
    public String getInstallmentsPattern() {
        return installmentsPattern;
    }

    /**
     * @param installmentsPattern The installments_pattern
     */
    public void setInstallmentsPattern(String installmentsPattern) {
        this.installmentsPattern = installmentsPattern;
    }

}
