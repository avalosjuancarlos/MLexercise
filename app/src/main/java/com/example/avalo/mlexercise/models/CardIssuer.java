package com.example.avalo.mlexercise.models;

import javax.annotation.Generated;

import com.example.avalo.mlexercise.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CardIssuer {

    @SerializedName(Constants.CardIssuer.ID)
    @Expose
    private String id;
    @SerializedName(Constants.CardIssuer.NAME)
    @Expose
    private String name;
    @SerializedName(Constants.CardIssuer.SECURE_THUMBNAIL)
    @Expose
    private String secureThumbnail;
    @SerializedName(Constants.CardIssuer.THUMBNAIL)
    @Expose
    private String thumbnail;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The secureThumbnail
     */
    public String getSecureThumbnail() {
        return secureThumbnail;
    }

    /**
     *
     * @param secureThumbnail
     * The secure_thumbnail
     */
    public void setSecureThumbnail(String secureThumbnail) {
        this.secureThumbnail = secureThumbnail;
    }

    /**
     *
     * @return
     * The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     *
     * @param thumbnail
     * The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}