package com.example.estateagency.domain.mapper;

import com.example.estateagency.domain.Client;

import org.json.JSONException;
import org.json.JSONObject;

public class ClientMapper {
    public static Client clientFromJson(JSONObject jsonObject) {
        Client client = null;
        try {
            client = new Client(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    jsonObject.getString("phone"),
                    jsonObject.getString("email")
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return client;
    }

    public static Client clientFromDealJson(JSONObject jsonObject) {
        Client client = null;

        try {
            client = new Client(
                    jsonObject.getJSONObject("clientDto").getInt("id"),
                    jsonObject.getJSONObject("clientDto").getString("name"),
                    jsonObject.getJSONObject("clientDto").getString("phone"),
                    jsonObject.getJSONObject("clientDto").getString("email"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return client;
    }
}
