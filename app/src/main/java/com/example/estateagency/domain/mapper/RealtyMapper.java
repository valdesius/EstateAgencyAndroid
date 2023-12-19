package com.example.estateagency.domain.mapper;

import com.example.estateagency.domain.Realty;
import com.example.estateagency.domain.enums.RealtyEnum;

import org.json.JSONException;
import org.json.JSONObject;

public class RealtyMapper {
    public static Realty realtyFromJson(JSONObject jsonObject) {
        Realty realty = null;
        try {
            realty = new Realty(
                    jsonObject.getInt("id"),
                    jsonObject.getString("address"),
                    RealtyEnum.valueOf(jsonObject.getString("type")), //TODO
                    jsonObject.getInt("area"),
                    jsonObject.getInt("price")
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return realty;
    }

    public static Realty realtyFromDealJson(JSONObject jsonObject) {
        Realty realty = null;

        try {
            realty = new Realty(
                    jsonObject.getJSONObject("realtyDto").getInt("id"),
                    jsonObject.getJSONObject("realtyDto").getString("address"),
                    RealtyEnum.valueOf(jsonObject.getJSONObject("realtyDto").getString("type")), //TODO
                    jsonObject.getJSONObject("realtyDto").getInt("area"),
                    jsonObject.getJSONObject("realtyDto").getInt("price"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return realty;
    }
}
