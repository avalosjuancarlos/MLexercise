package com.example.avalo.mlexercise.api;

import com.example.avalo.mlexercise.models.CardIssuer;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class CardIssuersDeserializer implements JsonDeserializer<CardIssuer> {

    private Gson mGson;

    public CardIssuersDeserializer() {
        mGson = new Gson();
    }

    @Override
    public CardIssuer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        CardIssuer cardIssuer = mGson.fromJson(json, CardIssuer.class);

        return cardIssuer;
    }
}
