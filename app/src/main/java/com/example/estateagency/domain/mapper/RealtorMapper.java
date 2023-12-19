package com.example.estateagency.domain.mapper;

import com.example.estateagency.domain.Realtor;

import org.json.JSONException;
import org.json.JSONObject;

public class RealtorMapper {
    public static Realtor realtorFromJson(JSONObject jsonObject) {
        Realtor realtor = null;
        try {
            realtor = new Realtor(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    jsonObject.getString("phone"),
                    jsonObject.getString("email")
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return realtor;
    }

    public static Realtor realtorFromDealJson(JSONObject jsonObject) {
        Realtor realtor = null;

        try {
            realtor = new Realtor(
                    jsonObject.getJSONObject("realtorDto").getInt("id"),
                    jsonObject.getJSONObject("realtorDto").getString("name"),
                    jsonObject.getJSONObject("realtorDto").getString("phone"),
                    jsonObject.getJSONObject("realtorDto").getString("email"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return realtor;
    }
}
