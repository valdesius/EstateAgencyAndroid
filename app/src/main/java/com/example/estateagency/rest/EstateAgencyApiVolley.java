package com.example.estateagency.rest;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.estateagency.MainActivity;
import com.example.estateagency.domain.Client;
import com.example.estateagency.domain.Deal;
import com.example.estateagency.domain.Realtor;
import com.example.estateagency.domain.Realty;
import com.example.estateagency.domain.enums.DealEnum;
import com.example.estateagency.domain.enums.RealtyEnum;
import com.example.estateagency.domain.mapper.ClientMapper;
import com.example.estateagency.domain.mapper.DealMapper;
import com.example.estateagency.domain.mapper.RealtorMapper;
import com.example.estateagency.domain.mapper.RealtyMapper;
import com.example.estateagency.nodb.NoDb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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

                            ((MainActivity) context).updateAdapter();
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
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/client";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onResponse(JSONArray response) {
                        NoDb.CLIENT_LIST.clear();
                        try {
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);
                                Client client = ClientMapper.clientFromJson(jsonObject);
                                NoDb.CLIENT_LIST.add(client);
                            }

                            ((MainActivity) context).updateAdapter();
                            Log.d(API_TEST, NoDb.CLIENT_LIST.toString());
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
    public void fillRealtor() {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/realtor";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onResponse(JSONArray response) {
                        NoDb.REALTOR_LIST.clear();
                        try {
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);
                                Realtor realtor = RealtorMapper.realtorFromJson(jsonObject);
                                NoDb.REALTOR_LIST.add(realtor);
                            }

                            ((MainActivity) context).updateAdapter();
                            Log.d(API_TEST, NoDb.REALTOR_LIST.toString());
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
    public void fillRealty() {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/realty";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onResponse(JSONArray response) {
                        NoDb.REALTY_LIST.clear();
                        try {
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);
                                Realty realty = RealtyMapper.realtyFromJson(jsonObject);
                                NoDb.REALTY_LIST.add(realty);
                            }

                            ((MainActivity) context).updateAdapter();
                            Log.d(API_TEST, NoDb.REALTY_LIST.toString());
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
    public void addDeal(Deal deal) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/deal";

        StringRequest request = new StringRequest(
                Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                fillDeal();
                Log.d(API_TEST, response);
            }
        },
                errorListener
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("date", String.valueOf(deal.getDate()));
                params.put("type", String.valueOf(deal.getType()));
                params.put("clientName", deal.getClient().getName());
                params.put("clientPhone", deal.getClient().getPhone());
                params.put("clientEmail", deal.getClient().getEmail());
                params.put("realtorName", deal.getRealtor().getName());
                params.put("realtorPhone", deal.getRealtor().getPhone());
                params.put("realtorEmail", deal.getRealtor().getEmail());
                params.put("realtyAddress", deal.getRealty().getAddress());
                params.put("realtyType", String.valueOf(deal.getRealty().getType()));
                params.put("area", String.valueOf(deal.getRealty().getArea()));
                params.put("price", String.valueOf(deal.getRealty().getPrice()));


                return params;
            }
        };
        requestQueue.add(request);
    }

    @Override
    public void updateDeal(int id, LocalDate date, DealEnum type, String clientName, String clientPhone, String clientEmail, String realtorName, String realtorPhone, String realtorEmail, String realtyAddress, RealtyEnum realtyType, int area, int price) {

    }

    @Override
    public void deleteDeal(int id) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/deal" + "/" + id;

        StringRequest request = new StringRequest(
                Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                fillDeal();
                Log.d(API_TEST, response);
            }
        },
                errorListener
        );
        requestQueue.add(request);
    }
}
