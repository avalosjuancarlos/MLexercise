package com.example.avalo.mlexercise.api;

import com.example.avalo.mlexercise.models.PaymentMethod;
import com.example.avalo.mlexercise.models.Setting;
import com.example.avalo.mlexercise.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodDeserializer implements JsonDeserializer<PaymentMethod> {

    private Gson mGson;

    public PaymentMethodDeserializer() {
        mGson = new Gson();
    }

    @Override
    public PaymentMethod deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        PaymentMethod paymentMethod = mGson.fromJson(json, PaymentMethod.class);

        JsonElement settings = json.getAsJsonObject().get(Constants.PaymentMethod.SETTINGS);

        if (!settings.isJsonArray())
            paymentMethod.setSettings(null);
        else
            paymentMethod.setSettings(parseSettings(settings.getAsJsonArray()));

        return paymentMethod;
    }

    private List<Setting> parseSettings(JsonArray jsonSettings) {
        List<Setting> settings = new ArrayList<>();
        for (JsonElement setting :
                jsonSettings) {
            settings.add(mGson.fromJson(setting, Setting.class));
        }

        return settings;
    }
}
