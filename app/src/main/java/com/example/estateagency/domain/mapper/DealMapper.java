package com.example.estateagency.domain.mapper;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.estateagency.domain.Deal;
import com.example.estateagency.domain.enums.DealEnum;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;

public class DealMapper {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Deal dealFromJson(JSONObject jsonObject) {
        Deal deal = null;

        try {
            deal = new Deal(
                    jsonObject.getInt("id"),
                    LocalDate.parse(jsonObject.getString("date")), //TODO!!!!!!!!!!
                    DealEnum.valueOf(jsonObject.getString("type")),
                    ClientMapper.clientFromDealJson(jsonObject),
                    RealtorMapper.realtorFromDealJson(jsonObject),
                    RealtyMapper.realtyFromDealJson(jsonObject)
                    );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return deal;
    }

}
