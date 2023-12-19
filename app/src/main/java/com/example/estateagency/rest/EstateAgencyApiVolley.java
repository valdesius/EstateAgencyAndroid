package com.example.estateagency.rest;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.estateagency.domain.Deal;
import com.example.estateagency.domain.enums.DealEnum;
import com.example.estateagency.domain.enums.RealtyEnum;
import com.example.estateagency.domain.mapper.DealMapper;
import com.example.estateagency.nodb.NoDb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;

public class EstateAgencyApiVolley implements EstateAgencyApi {
    public static final String API_TEST = "API_TEST";
    private final Context context;
    public static final String BASE_URL = "http://192.168.0.36:8081"; //todo buy server
    private Response.ErrorListener errorListener;

    public EstateAgencyApiVolley(Context context) {
        this.context = context;
        errorListener = error -> Log.d(API_TEST, error.toString());


    }

    @Override
    public void fillDeal() {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/deal";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onResponse(JSONArray response) {
                        NoDb.DEAL_LIST.clear();
                        try {
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);
                                Deal deal = DealMapper.dealFromJson(jsonObject); //todo
                                NoDb.DEAL_LIST.add(deal);
                            }
                            Log.d(API_TEST, NoDb.DEAL_LIST.toString());
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                errorListener

        );

        requestQueue.add(arrayRequest);

    }

    @Override
    public void fillClient() {

    }

    @Override
    public void fillRealtor() {

    }

    @Override
    public void fillRealty() {

    }

    @Override
    public void addDeal(Deal deal) {

    }

    @Override
    public void updateDeal(int id, LocalDate date, DealEnum type, String clientName, String clientPhone, String clientEmail, String realtorName, String realtorPhone, String realtorEmail, String realtyAddress, RealtyEnum realtyType, int area, int price) {

    }
}
