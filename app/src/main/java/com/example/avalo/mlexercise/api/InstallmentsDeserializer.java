package com.example.avalo.mlexercise.api;

import com.example.avalo.mlexercise.models.Installment;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class InstallmentsDeserializer implements JsonDeserializer<Installment> {

        private Gson mGson;

        public InstallmentsDeserializer() {
            mGson = new Gson();
        }

        @Override
        public Installment deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Installment installment = mGson.fromJson(json, Installment.class);

            return installment;
        }
    }
